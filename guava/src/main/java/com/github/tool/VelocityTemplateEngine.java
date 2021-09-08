package com.github.tool;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;
import org.apache.velocity.util.introspection.UberspectImpl;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/8/9 22:32
 */
public class VelocityTemplateEngine {

    private static VelocityTemplateEngine instance = new VelocityTemplateEngine();

    public static VelocityTemplateEngine getInstance() {
        return instance;
    }

    private final VelocityEngine velocityEngine;

    private final StringResourceRepository repository;

    private VelocityTemplateEngine() {
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

        velocityEngine = new VelocityEngine();
        velocityEngine.setExtendedProperties(configuration);
        velocityEngine.init();

        repository = StringResourceLoader.getRepository();
    }

    public void registerTemplate(String templateName, String templateContent) {
        repository.putStringResource(templateName, templateContent, StandardCharsets.UTF_8.displayName());
    }

    public String execute(String templateName, Map<String, ?> context) {
        Template template = getTemplate(templateName);
        Context ctx = buildContext(context);
        return execute(template, ctx);
    }

    public String execute(String templateName, String templateContent, Map<String, ?> context) {
        Template template;
        try {
            template = getTemplate(templateName);
        } catch (ResourceNotFoundException e) {
            registerTemplate(templateName, templateContent);
            template = getTemplate(templateName);
        }
        Context ctx = buildContext(context);
        return execute(template, ctx);
    }

    private Context buildContext(Map<String, ?> context) {
        VelocityContext velocityContext = new VelocityContext(context);
        velocityContext.put("dmp", new DmpDateTool());
        return velocityContext;
    }

    private Template getTemplate(String name) {
        return velocityEngine.getTemplate(name, StandardCharsets.UTF_8.displayName());
    }

    private String execute(Template template, Context context) {
        StringBuilderWriter writer = new StringBuilderWriter();
        template.merge(context, writer);

        return writer.toString().trim();
    }

    public static void main(String[] args) {

        String EXPRESSION_FORMAT = "#if(%s) true #else false #end";
        String e1 = "(${realtime_normal_action_order_cnt} > 0)";
        String e2 = " ((${realtime_normal_action_last_pay_date} >= ${dmp.addDay(-60).format('yyyyMMdd')} " +
                "&& ${realtime_normal_action_last_pay_date} <= ${dmp.addDay(-31).format('yyyyMMdd')}) ) ";
        String e3 = "${realtime_normal_action_last_pay_date} >= ${dmp.addDayFormat(-60)} ";
        String e5="(((${realtime_normal_action_order_cnt} > 0) ) " +
                "&& ((${realtime_normal_action_last_pay_date} >= ${dmp.addDay(-60).format('yyyyMMdd')} " +
                "&& ${realtime_normal_action_last_pay_date} <= ${dmp.addDay(-31).format('yyyyMMdd')}) ) )";
        String crowdId = "9";
        Map<String, Integer> tagMap = new HashMap<>();
        tagMap.put("realtime_normal_action_order_cnt", 14);
        tagMap.put("realtime_normal_action_last_pay_date", 20210719);
        String resultExpression = VelocityTemplateEngine.instance.execute(crowdId, String.format(EXPRESSION_FORMAT, e3), tagMap);
        String resultExpression2 = VelocityTemplateEngine.instance.execute(crowdId, String.format(EXPRESSION_FORMAT, e3), tagMap);
        System.out.println(resultExpression);
        System.out.println(new DmpDateTool().addDayFormat(-60));
        System.out.println(new DmpDateTool().addDayFormat(-31));
        System.out.println(Integer.MAX_VALUE);

    }
}

