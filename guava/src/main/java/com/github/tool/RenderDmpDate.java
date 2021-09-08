package com.github.tool;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.util.introspection.UberspectImpl;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/8/6 10:08
 */
public class RenderDmpDate {

    private static final Properties PROPS = new Properties();
    private static VelocityEngine engine;

    static {
        try {
            ExtendedProperties configuration = new ExtendedProperties();
            configuration.setProperty(RuntimeConstants.RESOURCE_LOADER, "string");
            configuration.setProperty("string.resource.loader.class", StringResourceLoader.class.getName());
            configuration.setProperty("string.resource.loader.cache", "true");
            configuration.setProperty(RuntimeConstants.RESOURCE_MANAGER_DEFAULTCACHE_SIZE, "512");
            configuration.setProperty(RuntimeConstants.RESOURCE_MANAGER_LOGWHENFOUND, "false");
            configuration.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, NullLogChute.class.getName());
            configuration.setProperty(RuntimeConstants.INPUT_ENCODING, StandardCharsets.UTF_8.displayName());
            configuration.setProperty(RuntimeConstants.OUTPUT_ENCODING, StandardCharsets.UTF_8.displayName());
            configuration.setProperty(RuntimeConstants.PARSER_POOL_SIZE, 100);
            configuration.setProperty(RuntimeConstants.UBERSPECT_CLASSNAME, UberspectImpl.class.getName());

            engine = new VelocityEngine();
            engine.setExtendedProperties(configuration);
            engine.init();

        } catch (Exception e) {
        }
    }

    static Pattern pt = Pattern.compile("\\$\\{dmp.*?\\}");

    /**
     * @author jiaxue.peng
     * @param: template
     * @date 2021/8/6 10:14
     * @return: java.lang.String
     * @description
     */
    public static String render(String template, Map<String, String> paras) throws Exception {
        if (template == null) {
            return null;
        }
        Matcher matcher = pt.matcher(template);
        VelocityContext context = new VelocityContext(paras);
        while (matcher.find()) {
            String m = template.substring(matcher.start(), matcher.end());
            StringWriter sw = new StringWriter();
            try {
                context.put("dmp", new DmpDateTool());
                Velocity.evaluate(context, sw, "", m);
                if (m.equals(sw.toString())) {
                    throw new Exception("渲染日期失败:" + m);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }
            template = template.replace(m, sw.toString());
            matcher = pt.matcher(template);
        }
        // 取得velocity的上下文context
        StringWriter writer = new StringWriter();
        engine.evaluate(context, writer, "", template);
        return writer.toString();
    }

    /**
     * @author jiaxue.peng
     * @param: template
     * @date 2021/8/6 10:14
     * @return: java.lang.String
     * @description
     */
    public static String renderSimpleTemplate(String template, Map<String, String> paras) throws Exception {
        if (template == null) {
            return null;
        }
        VelocityContext context = new VelocityContext(paras);
        StringWriter writer = new StringWriter();
        engine.evaluate(context, writer, "", template);
        return writer.toString();
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> maps = new HashMap<>(1);
        maps.put("1111111", "tt");
        maps.put("order_cnt", "111");
        String template = "${dmp.addDay(-1).format(\"yyyyMMdd\")} ${dmp.addDay(-1).format(\"yyyyMMdd\")}";
        String template1 = "((${1111111} >= 0) ) \n";
        System.out.println(render(template, maps));
        System.out.println(renderSimpleTemplate(template1, maps));

//        String s = RenderHierarchyProperties.render("ssss${zdt.addDay(-2).format(\"yyMMdd\")}ss${zdt.getTime()}", null);

    }

}
