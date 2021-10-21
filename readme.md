#  search-mybatis-plus 查询辅助工具

## 项目介绍
search-mybatis-plus 是一款查询辅助工具包，以编程的方式模拟SQL语言进行数据查询，无缝集成Mybatis-plus，具有以下功能：
- 模拟SQL,以lambda方式进行构建SQL查询,直接构建查询，无需再写xml文件
- select中支持Max,Min,Avg等聚合函数,CaseWhen等子句,自定义函数
- 支持连表查询(left join/inner join/right join/cross join)
- 支持where多条件构造查询，支持构建自定义函数
- 支持groupBy,orderBy,having及分页查询
- 无缝集成mybatis-plus,mapper只需继承QBaseMapper就可使用，对业务无侵入

## 方法介绍(QBaseMapper)
- fetchQuery(SQLQuery) - 根据查询对象获取数据列表，返回对象列表
- fetchQueryInto(SQLQuery,Class) - 根据查询对象获取数据列表，转化成对应对象列表
- countQuery(SQLQuery) - 根据查询对应返回对应数据的总条数
- QDL 工具类包含条件及其他函数的创建引用,例如eq条件 -> QDL.eq()

## 使用
 * Mapper继承QBaseMapper(必须)
 * 构建SQLQuery
 * 调用QBaseMapper中方法查询数据

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
q.selectDistinct(SysMenu::getId, SysMenu::getRedirect, SysMenu::getBeHidden, SysMenu::getMenuName, SysMenu::getPriority,
	SysMenu::getIcon, SysMenu::getParentId, SysResourceApi::getReqUrl)
.from(SysMenu.class)
.leftJoin(SysRoleResource.class, and(eq(SysRoleResource::getResourceId, SysMenu::getId), eq(SysRoleResource::getResourceType, "MENU")))
.leftJoin(SysRole.class, eq(SysRole::getId, SysRoleResource::getRoleId))
.innerJoin(SysResourceApi.class, and(eq(SysResourceApi::getResourceId, SysMenu::getId), eq(SysResourceApi::getResourceType, "MENU")))
.where(eq(SysMenu::getMenuType, "BUSINESS"))
.orderByasc(SysMenu::getPriority, SysMenu::getParentId)
.limitOffset(1,10);
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
	sys_menu
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
q.selectDistinct(SysMenu::getId, SysMenu::getRedirect, SysMenu::getBeHidden, SysMenu::getMenuName, SysMenu::getPriority, SysMenu::getIcon, SysMenu::getParentId, SysResourceApi::getReqUrl,
	as(case_when().WHEN(lt(SysMenu::getPriority, 1)).THEN(1).ELSE(2), "condition"), as(sum(SysMenu::getPriority),"sum_total"))
.from(SysMenu.class)
.leftJoin(SysRoleResource.class, and(eq(SysRoleResource::getResourceId, SysMenu::getId), eq(SysRoleResource::getResourceType, "MENU")))
.leftJoin(SysRole.class, eq(SysRole::getId, SysRoleResource::getRoleId))
.innerJoin(SysResourceApi.class, and(eq(SysResourceApi::getResourceId, SysMenu::getId), eq(SysResourceApi::getResourceType, "MENU")))
.where(eq(SysMenu::getMenuType, "BUSINESS"))
.groupBy(SysMenu::getId, SysMenu::getRedirect, SysMenu::getBeHidden, SysMenu::getMenuName, SysMenu::getPriority,
		SysMenu::getIcon, SysMenu::getParentId, SysResourceApi::getReqUrl)
.having(gt(count("*"),1))
.orderByasc(SysMenu::getPriority, SysMenu::getParentId).limitOffset(1,10);
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
	(CASE WHEN sys_menu.priority < 1 THEN
			1
		ELSE
			2
		END) AS 'condition',
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