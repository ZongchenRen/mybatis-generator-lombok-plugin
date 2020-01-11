package com.softwareloop.mybatis.generator.plugins;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * @author renzongchen
 * @data 2020-01-11 13:39
 * @description   注释插件
 */
public class CommentGenerator extends DefaultCommentGenerator {
	 private Properties properties;
	 private Properties systemPro;
	 private boolean suppressDate;
	 private boolean suppressAllComments;
	 private String currentDateStr;

	 public CommentGenerator() {
		  super();
		  properties = new Properties();
		  systemPro = System.getProperties();
		  suppressDate = false;
		  suppressAllComments = false;
		  currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	 }

	 public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			 IntrospectedColumn introspectedColumn) {
		  if (suppressAllComments) {
				return;
		  }
		  StringBuilder sb = new StringBuilder();
		  field.addJavaDocLine("/**");
		  sb.append(" * ");
		  sb.append(introspectedColumn.getRemarks());
		  field.addJavaDocLine(sb.toString().replace("\n", " "));
		  field.addJavaDocLine(" */");
	 }

	 public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

	 }

	 public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

	 }

	 public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			 IntrospectedColumn introspectedColumn) {

	 }

	 public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			 IntrospectedColumn introspectedColumn) {

	 }

	 public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable,
			 boolean markAsDoNotDelete) {

	 }

	 public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
	 }
}