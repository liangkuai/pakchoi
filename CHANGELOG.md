# Changelog


## [v0.0.5]() - 2020-07-01
### Feat
- 解决 Bean 之间的互相依赖，也就是引用字段。
- 采用 lazy init 的方式解决循环依赖。


## [v0.0.4]() - 2020-07-01
### Feat
- 使用 xml 文件配置 Bean 的定义。
- 使用读取器解析 xml 配置文件并生成 BeanDefinition 对象。

### Fix
- issue#2
- issue#4
- issue#5


## [v0.0.3]() - 2019-05-20
### Feat
- BeanFactory「创建 Bean 实例」之后再「初始化 Bean 实例的字段值」，但是不能初始化引用字段（依赖的对象）。

### Fix
- issue#3


## [v0.0.2]() - 2019-05-05
### Feat
- 由 BeanFactory「创建 Bean 实例」。

### Fix
- issue#1


## [v0.0.1]() - 2019-05-05
### Feat
- 最简单的 IoC 容器。