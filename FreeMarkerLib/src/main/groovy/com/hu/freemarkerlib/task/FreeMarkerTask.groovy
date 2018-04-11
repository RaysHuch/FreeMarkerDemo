package com.hu.freemarkerlib.task

import com.hu.freemarkerlib.Generator
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class FreeMarkerTask extends DefaultTask {
  FreeMarkerTask() {
    super()
  }

  @TaskAction
  def doAction() {
    def pluginBean = project.extensions.pluginImpl
    println("----------------------------------------***************************--------------------")
    println(pluginBean.toString())
    def daoGenerator = new Generator()
    daoGenerator.generate(pluginBean.outDirFile,pluginBean.packageName, pluginBean.clazzName,pluginBean.id,pluginBean.sex,pluginBean.name)
  }
}