package com.hu.freemarkerlib;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class Generator {
    private static final String BEAN_KEY = "bean";
    private final Template myJavaFileFtl;

    public Generator() throws IOException {
        Configuration config = getConfiguration("myJavaFile.ftl");
        myJavaFileFtl = config.getTemplate("myJavaFile.ftl");
    }

    private Configuration getConfiguration(String template) throws IOException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_23);
        config.setClassForTemplateLoading(getClass(), "/");
        //这里要设置取消使用Local语言环境
//        config.setLocalizedLookup(false);
        try {
            config.getTemplate(template);
        } catch (TemplateNotFoundException e) {
            System.out.println("出错");
            File dir = new File("src/main/resources/");

            if (dir.exists() && new File(dir, template).exists()) {
                config.setDirectoryForTemplateLoading(dir);
                config.getTemplate(template);
            } else {
                throw e;
            }
        }
        return config;
    }

    public void generate(String outDirFileName, String packageName,String clazzName,int id,String sex,String name) throws Exception {
        // 创建数据模型
        Map<String, Object> root = new HashMap<>();
        TestBean testBean = new TestBean();
        testBean.setPackageName(packageName);
        testBean.setClazzName(clazzName);
        testBean.setId(id);
        testBean.setSex(sex);
        testBean.setName(name);
        //这里的key的名称要与模板里的名称一致，否则无法进行映射
        root.put(BEAN_KEY, testBean);

            File file = toJavaFilename(new File(outDirFileName), testBean.getPackageName(), testBean.getClazzName());
            //noinspection ResultOfMethodCallIgnored
            file.getParentFile().mkdirs();

            Writer writer = new FileWriter(file);
            try {
                myJavaFileFtl.process(root, writer);
                writer.flush();
                System.out.println("Written " + file.getCanonicalPath());
            } finally {
                writer.close();
            }
    }

    private File toJavaFilename(File outDirFile, String javaPackage, String javaClassName) {
        String packageSubPath = javaPackage.replace('.', '/');
        File packagePath = new File(outDirFile, packageSubPath);
        return new File(packagePath, javaClassName + ".java");
    }

    public static void main(String[] args) throws Exception {
        Generator daoGenerator = new Generator();

        daoGenerator.generate(args[0], args[1],args[2],Integer.parseInt(args[3]),args[4],args[5]);

    }
}
