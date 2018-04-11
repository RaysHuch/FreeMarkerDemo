package com.hu.freemarkerlib

import com.hu.freemarkerlib.bean.PluginBean
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import com.hu.freemarkerlib.task.FreeMarkerTask

public class PluginImpl implements Plugin<Project> {
    void apply(Project project) {
        println "Hello gradle plugin"
        project.extensions.create('pluginImpl', PluginBean)

        project.task("showName") << {
            def pluginBean = project.extensions.pluginImpl
            println("--------------------------------------------------------------------------------------")
            println(pluginBean.outDirFile);
            println(pluginBean.packageName);
            println(pluginBean.clazzName);
            println(pluginBean.id);
            println(pluginBean.sex);
        }

        def freeMarkerTask = project.tasks.create("FreeMarkerTask", FreeMarkerTask)

        project.afterEvaluate {
            freeMarkerTask.execute()
        }
    }
}