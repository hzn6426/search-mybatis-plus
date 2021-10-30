#  search-mybatis-plus 查询辅助工具
  群号816652102 欢迎交流
## 项目介绍
search-mybatis-plus 是一款查询辅助工具包，以编程的方式模拟SQL语言进行数据查询/更新/删除，无缝集成Mybatis-plus，具有以下功能：
- 模拟sql,以lambda方式进行构建SQL查询/更新/删除,无需再写xml文件
- Select中支持Max,Min,Avg等聚合函数,CaseWhen等子句,CTMFunction自定义函数
- 支持连表查询(left join/inner join/right join/cross join)
- 连表查询支持自连接查询(left join/inner join/right join),自连接适应于SQLQuery/SQLUpdate/SQLDelete
- 支持where多条件构造查询，支持构建CTMCondition自定义函数
- 支持groupBy,orderBy,having及分页查询
- 支持update语句,以lambda方式构建,支持update join(left join/inner join/right join) order by limit 等语句构建
- 支持delete语句,以lambda方式构建,支持delete join(left join/inner join/right join) order by limit 等语句构建
- 支持子查询(select子查询,from子查询,exist子查询,in子查询等)
- 支持加/减/乘/除/幂/模运算
- 无缝集成mybatis-plus,mapper只需继承QBaseMapper就可使用，对业务无侵入

## 方法介绍(QBaseMapper)
- fetchQuery(SQLQuery) - 根据查询对象获取数据列表，返回对象列表
- fetchQueryInto(SQLQuery,Class) - 根据查询对象获取数据列表，转成对应对象列表
- countQuery(SQLQuery) - 根据查询对应返回对应数据的总条数
- updateQuery(SQLUpdate update) - 执行构建的SQLUpdate,返回影响行数
- deleteQuery(SQLDelete delete) - 执行构建的SQLDelete,返回影响行数
- QDL 工具类包含条件及其他函数的创建引用,例如eq条件 -> QDL.eq()

## 使用
 
 添加 Maven(如果找不到可以用https://repo1.maven.org/maven2/) 依赖或者下载项目执行 "mvn clean install"
 
 ```java
	<groupId>com.baomibing</groupId>
	<artifactId>search-mybatis-plus</artifactId>
	<version>1.0.4</version>
 ```
 * Mapper继承QBaseMapper(必须)
 * service实现类实现SQLQueryService(可选),该接口包含条件的构建方法
 * 构建SQLQuery
 * 调用QBaseMapper中方法查询数据

具体例子请参考：https://gitee.com/ifrog/search-mybatis-plus-example

### 查询样例1
```java
SQLQuery query = new SQLQuery();
query.selectFrom(SysButton.class).limitOffset(1, 10);
List<ButtonDto> list = buttonMapper.fetchQueryInto(query, ButtonDto.class)
int count = buttonMapper.countQuery(query);
```
对应SQL为
```sql
SELECT * FROM sys_button LIMIT 10, OFFSET 0;
SELECT count(1) FROM sys_button
```
### 查询样例2
```java
SQLQuery q = new SQLQuery();
q.selectDistinct(
    SysMenu::getId,
    SysMenu::getRedirect,
    SysMenu::getBeHidden,
    SysMenu::getMenuName,
    SysMenu::getPriority,
    SysMenu::getIcon,
    SysMenu::getParentId,
    SysResourceApi::getReqUrl)
.from(SysMenu.class)
.leftJoin(SysRoleResource.class, eq(SysRoleResource::getResourceId,SysMenu::getId), eq(SysRoleResource::getResourceType,"MENU"))
.leftJoin(SysRole.class, eq(SysRole::getId,SysRoleResource::getRoleId))
.innerJoin(SysResourceApi.class,eq(SysResourceApi::getResourceId,SysMenu::getId), eq(SysResourceApi::getResourceType,"MENU"))
.where(eq(SysMenu::getMenuType,"BUSINESS"))
.orderByasc(SysMenu::getPriority,SysMenu::getParentId)
.limitOffset(1,10);
List<SysMenu> list = qbaseMapper.fetchQuery(q);
```
生成的SQL为
```sql
SELECT DISTINCT
    sys_menu.id,
    sys_menu.redirect,
    sys_menu.be_hidden,
    sys_menu.menu_name,
    sys_menu.priority,
    sys_menu.icon,
    sys_menu.parent_id,
    sys_resource_api.req_url
FROM
    sys_menu f
    LEFT JOIN sys_role_resource ON (sys_role_resource.resource_id = sys_menu.id AND sys_role_resource.resource_type = 'MENU')
    LEFT JOIN sys_role ON sys_role.id = sys_role_resource.role_id
    INNER JOIN sys_resource_api ON (sys_resource_api.resource_id = sys_menu.id AND sys_resource_api.resource_type = 'MENU')
WHERE
    sys_menu.menu_type = 'BUSINESS'
ORDER BY
    sys_menu.priority,
    sys_menu.parent_id ASC
LIMIT 10 OFFSET 0
```
### 查询样例3
```java
SQLQuery q=new SQLQuery();
q.selectDistinct(
    SysMenu::getId, 
    SysMenu::getRedirect, 
    SysMenu::getBeHidden, 
    SysMenu::getMenuName, 
    SysMenu::getPriority, 
    SysMenu::getIcon, 
    SysMenu::getParentId, 
    SysResourceApi::getReqUrl,
    as(case_when().WHEN(lt(SysMenu::getPriority, 1)).THEN(1).ELSE(2), "condition"),
    as(sum(SysMenu::getPriority),"sum_total"))
.from(SysMenu.class)
.leftJoin(SysRoleResource.class, eq(SysRoleResource::getResourceId, SysMenu::getId), eq(SysRoleResource::getResourceType, "MENU"))
.leftJoin(SysRole.class, eq(SysRole::getId, SysRoleResource::getRoleId))
.innerJoin(SysResourceApi.class, eq(SysResourceApi::getResourceId, SysMenu::getId), eq(SysResourceApi::getResourceType, "MENU"))
.where(eq(SysMenu::getMenuType, "BUSINESS"))
.groupBy(
    SysMenu::getId, 
    SysMenu::getRedirect, 
    SysMenu::getBeHidden, 
    SysMenu::getMenuName, 
    SysMenu::getPriority,
    SysMenu::getIcon, 
    SysMenu::getParentId, 
    SysResourceApi::getReqUrl)
.having(gt(count("*"),1))
.orderByasc(SysMenu::getPriority, SysMenu::getParentId)
.limitOffset(1,10);
List<SysMenu> list = qbaseMapper.fetchQuery(q);
```
生成的SQL为
```sql
SELECT DISTINCT
    sys_menu.id,
    sys_menu.redirect,
    sys_menu.be_hidden,
    sys_menu.menu_name,
    sys_menu.priority,
    sys_menu.icon,
    sys_menu.parent_id,
    sys_resource_api.req_url,
    (CASE WHEN sys_menu.priority < 1 
        THEN 1
        ELSE 2 END) AS 'condition',
    SUM(sys_menu.priority) AS 'sum_total'
FROM
    sys_menu
    LEFT JOIN sys_role_resource ON (sys_role_resource.resource_id = sys_menu.id
            AND sys_role_resource.resource_type = 'MENU')
    LEFT JOIN sys_role ON sys_role.id = sys_role_resource.role_id
    INNER JOIN sys_resource_api ON (sys_resource_api.resource_id = sys_menu.id
        AND sys_resource_api.resource_type = 'MENU')
WHERE
    sys_menu.menu_type = 'BUSINESS'
GROUP BY
    sys_menu.id,
    sys_menu.redirect,
    sys_menu.be_hidden,
    sys_menu.menu_name,
    sys_menu.priority,
    sys_menu.icon,
    sys_menu.parent_id,
    sys_resource_api.req_url
HAVING
    COUNT(*) > 1
ORDER BY
    sys_menu.priority,
    sys_menu.parent_id ASC
LIMIT 10 OFFSET 0;
```
### 自连表查询样例
```java
SQLQuery query = new SQLQuery();
Alias alias1 = new Alias(SysGroup.class, "g1");
Alias alias2 = new Alias(SysGroup.class, "g2");
query.selectDistinct(alias2.Fields(SysGroup::getId, SysGroup::getGroupLevel, SysGroup::getGroupName))
    .from(alias1)
    .leftJoin(alias2, like(alias1.Fields(SysGroup::getParentId), alias2.Fields(SysGroup::getId)), eq(alias2.Fields(SysGroup::getGroupLevel), 1))
    .where(eq(alias1.Fields(SysGroup::getId), "R0101"));
```
生成的SQL为
```sql
SELECT DISTINCT
    g2.`id`,
    g2.`group_level`,
    g2.`group_name`
FROM 
    sys_group AS g1
    LEFT JOIN sys_group AS g2 ON (g1.`parent_id` LIKE CONCAT('%', g2.`id`, '%') AND g2.`group_level` = 1)
WHERE
    g1.`id` = 'R0101'
```
### 更新样例
```java
SQLUpdate sqlUpdate = new SQLUpdate(SysButton.class);
sqlUpdate
    .set(eq(SysButton::getButtonName, "test"), eq(SysButton::getMenuId, "test_menu"))
    .where(eq(SysButton::getId, "1442023718292295681"));
Integer updateCount = buttonMapper.updateQuery(sqlUpdate);
```
生成的SQL为
```sql
UPDATE sys_button 
    SET sys_button.`button_name` = 'test', sys_button.`menu_id` = 'test_menu' 
WHERE sys_button.`id` = '1442023718292295681'
```
### 删除样例
```java
SQLDelete sqlDelete = new SQLDelete();
sqlDelete.from(SysButton.class).where(eq(SysButton::getId, "1442023718292295681"));
Integer deleteCount = buttonMapper.deleteQuery(sqlDelete);
```
生成的SQL为
```sql
DELETE FROM sys_button WHERE sys_button.`id` = '1442023718292295681'
```