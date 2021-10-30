## 更新日志
### 2021-10-20[1.0.0]
- 添加SQLQuery定义及构建逻辑
- 添加Select子句及构建逻辑
- 添加Join子句及构建逻辑
- 添加Where子句及构建逻辑
- 添加GroupBy子句及构建逻辑
- 添加Having子句及构建逻辑
- 添加OrderBy子句及构建逻辑
- 添加AS,DISTINCT,CASE WHEN等子句及构建逻辑
- 添加SUM,AVG,MAX,MIN,自定义函数等函数及构建逻辑
- 添加AND,OR,EQ,自定义函数等条件子句及构建逻辑
- 添加QBaseMapper与Mybatis-plus集成

### 2021-10-22[1.0.1]
- where 条件多个时,默认为AND连接
- join(left/right/inner)多个条件时,默认为AND连接
- having多个条件时,默认为AND连接
- 优化from 可以进行子查询
- select 优化可以选择子查询(需要使用AS关键字)
- 条件添加beTrue(boolean)参数,beTrue为真时才进行条件拼接
- join添加beTrue(boolean)参数,beTrue为真时才进行条件拼接

### 2021-10-26[1.0.2]
- 添加SQLQueryService接口，包含了常用的条件等构建方法，可以直接在基础服务类中实现
- 添加SQLUpdate用来进行数据更新
- 添加SQLDelete用来进行数据删除
- QBaseMapper添加updateQuery用来执行更新方法
- QBaseMapper添加deleteQuery用来执行删除方法

### 2021-10-27[1.0.3]
- 添加ADD表达式(加法)
- 添加DIVISION表达式(减法)
- 添加MULTIPL表达式(乘法)
- 添加DIVISION表达式(除法)
- 添加MOD表达式(取模)
- 添加POW表达式(取幂)
- EQ,LT,GT等条件支持表达式(可以用于update set语句)
- 添加自连接(Alias机制)查询(left join/inner join/right join)
- 升级mybatis-plus到3.4.3.4版本
- 优化SQLQueryService 和 QDL 中泛型错误
### 2021-10-30[1.0.4]
- 添加field构造可以进行列构造
- select和selectDistinct中添加field构造
- 重构条件，添加field(列，主要用于多表别名)构造
- from(SQLQuery)可以进行重命名以便条件中使用
- 修复条件拼接对应的bug
- 添加测试demo
