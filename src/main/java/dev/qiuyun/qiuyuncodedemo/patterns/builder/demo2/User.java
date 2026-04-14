package dev.qiuyun.qiuyuncodedemo.patterns.builder.demo2;
/**
 * ============================================
 * Java 建造者模式 - Lombok @Builder 注解
 * ============================================
 */

/**
 * 使用 Lombok 简化建造者模式
 * Lombok 会在编译时自动生成 Builder 类
 */
@lombok.Builder
@lombok.ToString
@lombok.Getter
class User {
    private String name;
    private int age;
    private String email;
    private String phone;

    // Lombok 生成的 Builder 使用示例
    static void lombokBuilderExample() {
        System.out.println("\n=== Lombok @Builder 示例 ===");

        // 使用链式调用构建对象
        User user1 = User.builder()
                .name("张三")
                .age(25)
                .email("zhangsan@example.com")
                .build();

        System.out.println("用户1: " + user1);

        // 只设置必需字段
        User user2 = User.builder()
                .name("李四")
                .age(30)
                .build();

        System.out.println("用户2: " + user2);
    }

    public static void main(String[] args) {
        lombokBuilderExample();
    }
}
