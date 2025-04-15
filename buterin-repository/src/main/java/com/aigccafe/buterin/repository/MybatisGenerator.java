package com.aigccafe.buterin.repository;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MybatisGenerator {
    public static void main(String[] args) throws IOException, XMLParserException,
            SQLException, InterruptedException, InvalidConfigurationException {

        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;

        ConfigurationParser cp = new ConfigurationParser(warnings);
        InputStream path = getResourceInClasspath("mybatis/generatorConfig.xml");
        if (path == null) {
            System.out.println("xml文件path解析为空");

        } else {
            Configuration config = cp.parseConfiguration(path);

            DefaultShellCallback callback = new DefaultShellCallback(overwrite);

            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

            myBatisGenerator.generate(null);

            warnings.forEach(System.out::println);

        }
    }

    public static InputStream getResourceInClasspath(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }
}

