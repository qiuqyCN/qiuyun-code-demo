package dev.qiuyun.qiuyuncodedemo.patterns.builder.demo3;

// 内部 Builder 使用示例
class DatabaseConfigExample {
    public static void main(String[] args) {
        System.out.println("\n=== 内部 Builder 示例 ===");

        // 使用链式调用构建复杂对象
        DatabaseConfig config1 = new DatabaseConfig.Builder()
                .host("db.example.com")
                .port(5432)
                .database("production")
                .username("admin")
                .password("secret")
                .maxConnections(100)
                .timeout(60)
                .enableCache(true)
                .charset("UTF-8")
                .build();

        System.out.println("配置1: " + config1);

        // 使用默认值
        DatabaseConfig config2 = new DatabaseConfig.Builder()
                .database("development")
                .build();

        System.out.println("配置2: " + config2);
    }
}
