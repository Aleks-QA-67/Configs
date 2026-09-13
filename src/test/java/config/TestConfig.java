package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {

    private static final Properties props = new Properties();
    static {
        try (InputStream propsStream = TestConfig.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            props.load(propsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUrl() {
        return props.getProperty("URL");
    }

    public static String getApiUrl() {
        return props.getProperty("API_URL");
    }

    public static long getTimeout() {
        return Long.parseLong(props.getProperty("TIMEOUT"));
    }

    public static boolean isLogging() {
        return Boolean.parseBoolean(props.getProperty("LOGGING"));
    }

    public static String getAdminLogin() {
        return props.getProperty("ADMIN_LOGIN");
    }

    public static String getAdminPassword() {
        return props.getProperty("ADMIN_PASSWORD");
    }

    public static String getGoodName() {
        return props.getProperty("GOOD_NAME");
    }

    public static String getGoodPrice() {
        return props.getProperty("GOOD_PRICE");
    }

    // Вывод всех параметров, КРОМЕ логина и пароля
    public static void printConfig() {
        System.out.println("=== Конфигурация ===");
        System.out.println("URL: " + getUrl());
        System.out.println("API_URL: " + getApiUrl());
        System.out.println("TIMEOUT: " + getTimeout());
        System.out.println("LOGGING: " + isLogging());
        System.out.println("GOOD_NAME: " + getGoodName());
        System.out.println("GOOD_PRICE: " + getGoodPrice());
        System.out.println("====================");
    }
}