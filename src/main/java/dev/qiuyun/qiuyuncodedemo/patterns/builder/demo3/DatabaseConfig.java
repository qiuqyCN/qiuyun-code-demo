package dev.qiuyun.qiuyuncodedemo.patterns.builder.demo3; /**
 * ============================================
 * Java 建造者模式 - 传统内部 Builder 类
 * ============================================
 */

/**
 * 产品：复杂配置对象
 */
class DatabaseConfig {
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;
    private int maxConnections;
    private int timeout;
    private boolean enableCache;
    private String charset;

    // 私有构造函数，强制使用 Builder
    private DatabaseConfig(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.database = builder.database;
        this.username = builder.username;
        this.password = builder.password;
        this.maxConnections = builder.maxConnections;
        this.timeout = builder.timeout;
        this.enableCache = builder.enableCache;
        this.charset = builder.charset;
    }

    @Override
    public String toString() {
        return String.format(
            "DatabaseConfig{host='%s', port=%d, database='%s', maxConnections=%d, timeout=%d}",
            host, port, database, maxConnections, timeout
        );
    }

    /**
     * 内部 Builder 类
     */
    public static class Builder {
        private String host = "localhost";
        private int port = 3306;
        private String database = "testdb";
        private String username = "root";
        private String password = "";
        private int maxConnections = 10;
        private int timeout = 30;
        private boolean enableCache = false;
        private String charset = "UTF-8";

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder database(String database) {
            this.database = database;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder maxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder enableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public Builder charset(String charset) {
            this.charset = charset;
            return this;
        }

        public DatabaseConfig build() {
            return new DatabaseConfig(this);
        }
    }
}
