# 秋云编程公众号文章示例代码

## 项目简介

本项目是「秋云编程」公众号文章的示例代码仓库，主要包含 Java 开发相关的技术示例和实践代码。

## 项目结构

```
qiuyun-code-demo/
├── src/
│   ├── main/java/dev/qiuyun/qiuyuncodedemo/
│   │   ├── limit/           # 限流示例
│   │   ├── patterns/        # 设计模式示例
│   │   └── [其他模块]/      # 其他功能模块
│   └── main/resources/      # 资源文件
├── pom.xml                  # Maven 依赖配置
└── README.md                # 项目说明文档
```

## 主要功能模块

### 1. 限流模块 (limit)
- `RateLimitedExecutor.java` - 基于令牌桶算法的限流执行器
- `TaobaoIpDemo.java` - 使用限流执行器调用淘宝 IP 查询接口的示例

### 2. 设计模式模块 (patterns)

## 技术栈

- Java 25
- Spring Boot 4.0.5
- Spring WebMVC
- Guava (限流依赖)
- H2 数据库 (测试用)

## 如何运行

1. 克隆本仓库：
   ```bash
   git clone [仓库地址]
   ```

2. 进入项目目录：
   ```bash
   cd qiuyun-code-demo
   ```

3. 使用 Maven 构建项目：
   ```bash
   mvn clean install
   ```

4. 运行示例代码：
   ```bash
   mvn exec:java -Dexec.mainClass="dev.qiuyun.qiuyuncodedemo.limit.TaobaoIpDemo"
   ```

## 相关文章

- [Java限流神器：手写一个通用限流任务执行器，支持重试和指数退避！](https://mp.weixin.qq.com/s/5a3vi60g6tahNhgc-K_fTQ) - 介绍限流模块的实现原理
- [文章标题 2](文章链接) - Spring Boot 4 新特性详解

## 联系方式

- 公众号：秋云编程
- 作者：秋云

## 许可证

本项目采用 MIT 许可证，详见 LICENSE 文件。


