# Changelog


## [v0.0.5]() - 2020-07-01
### Feat
- 解决 Bean 之间的互相依赖，也就是引用字段。
- 采用 lazy init 的方式解决循环依赖。


## [v0.0.4]() - 2020-07-01
### Feat
- 不再需要手动创建并初始化 BeanDefinition 对象，并手动注入 IoC 容器。
- 通过读取 xml 配置文件，解析并生成 BeanDefinition 对象，再注册到 IoC 容器中。

### Fix
- issue#2
- issue#4
- issue#5


## [v0.0.3]() - 2019-05-20
### Feat
- IoC 容器在创建 Bean 对象的同时设置字段和初始值。

### Fix
- issue#3


## [v0.0.2]() - 2019-05-05
### Feat
- 由 IoC 容器创建 Bean 对象。

### Fix
- issue#1


## [v0.0.1]() - 2019-05-05
### Feat
- 最简单的 IoC 容器。