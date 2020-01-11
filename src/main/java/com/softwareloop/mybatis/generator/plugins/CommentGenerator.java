package com.softwareloop.mybatis.generator.plugins;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * @author renzongchen
 * @data 2020-01-11 13:39
 * @description 注释插件
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

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

	}

	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

	}

	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

	}

	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable,
			boolean markAsDoNotDelete) {

	}

	@Override
	public void addModelClassComment(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		String author = properties.getProperty("author","renzongchen");
		String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd mm:ss");
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		// 获取表注释
		String remarks = introspectedTable.getRemarks();
		topLevelClass.addJavaDocLine("/**");
		topLevelClass.addJavaDocLine(" * @author " + author);
		topLevelClass.addJavaDocLine(" * @date " + format.format(new Date()));
		topLevelClass.addJavaDocLine(" * @description " + remarks);
		topLevelClass.addJavaDocLine(" */");
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		super.addClassComment(innerClass, introspectedTable);
	}

	 @Override public void addConfigurationProperties(Properties properties) {
		  super.addConfigurationProperties(properties);
	 }

	 @Override public void addComment(XmlElement xmlElement) {

	 }
}