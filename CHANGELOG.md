# Changelog


## [v0.0.4]() - 2020-07-01
### Feat
- 不再需要手动创建并初始化 BeanDefinition 对象，并手动注入 IoC 容器。
- 通过读取 xml 配置文件，解析并生成 BeanDefinition 对象，再注册到 IoC 容器中。


## [v0.0.3]() - 2019-05-20
### Feat
- BeanDefinition 中存储 Bean 的字段和值。
- IoC 容器在创建 Bean 对象的同时设置字段和值。


## [v0.0.2]() - 2019-05-05
### Feat
- 由 IoC 容器创建 Bean 对象。


## [v0.0.1]() - 2019-05-05
### Feat
- 最简单的 IoC 容器。