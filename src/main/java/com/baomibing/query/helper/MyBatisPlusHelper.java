package com.baomibing.query.helper;

import static java.util.Locale.ENGLISH;

import java.util.concurrent.TimeUnit;

import org.apache.ibatis.reflection.property.PropertyNamer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import com.baomibing.query.constant.Strings;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.ColumnCache;
import com.baomidou.mybatisplus.core.toolkit.support.LambdaMeta;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
/**
 * mybatis-plus tool
 * @see com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper
 * 
 * @author zening
 * @since 1.0.0
 */
public abstract class MyBatisPlusHelper {
	
	private static final LoadingCache<String, ColumnCache> cache = Caffeine.newBuilder()
		.expireAfterAccess(30, TimeUnit.MINUTES)
		.maximumSize(1000)
		.build(new CacheLoader<String, ColumnCache>() {
			@Override
			public @Nullable ColumnCache load(@NonNull String key) throws Exception {
				return null;
			}
		});
	
	public static <T> Class<?> getClass(SFunction<?, ?> column) {
//		SerializedLambda lambda = LambdaUtils.resolve(column);
//		Class<?> aClass = lambda.getInstantiatedType();

		// mybatis-plus v3.4.3.4
		LambdaMeta meta = LambdaUtils.extract(column);
		Class<?> instantiatedClass = meta.getInstantiatedClass();
		return instantiatedClass;
	}

	public static <T> String columnToString(SFunction<?, ?> column) {
		// mybatis-plus v3.4.0
//		SerializedLambda lambda = LambdaUtils.resolve(column);
//		Class<?> aClass = lambda.getInstantiatedType();
//		String fieldName = PropertyNamer.methodToProperty(lambda.getImplMethodName());

		// mybatis-plus v3.4.3.4
		LambdaMeta meta = LambdaUtils.extract(column);
		String fieldName = PropertyNamer.methodToProperty(meta.getImplMethodName());
		Class<?> instantiatedClass = meta.getInstantiatedClass();

//		
		TableInfo info = TableInfoHelper.getTableInfo(instantiatedClass);
		String tableName = info.getTableName();
		ColumnCache columnCache = cache.get(formatKey(tableName + Strings.DOT + fieldName));
		if (columnCache == null) {
			createCache(info);
		}
		columnCache = cache.get(formatKey(tableName + Strings.DOT + fieldName));
		return tableName + Strings.DOT + "`" + columnCache.getColumn() + "`";
	}
	

	public static <T> String columnToString(SFunction<?, ?> column, String tableAlias) {
//		SerializedLambda lambda = LambdaUtils.resolve(column);
//		Class<?> aClass = lambda.getInstantiatedType();
//		String fieldName = PropertyNamer.methodToProperty(lambda.getImplMethodName());

		// mybatis-plus v3.4.3.4
		LambdaMeta meta = LambdaUtils.extract(column);
		String fieldName = PropertyNamer.methodToProperty(meta.getImplMethodName());
		Class<?> instantiatedClass = meta.getInstantiatedClass();
		TableInfo info = TableInfoHelper.getTableInfo(instantiatedClass);
		String tableName = info.getTableName();
		ColumnCache columnCache = cache.get(formatKey(tableName + Strings.DOT + fieldName));
		if (columnCache == null) {
			createCache(info);
		}
		columnCache = cache.get(formatKey(tableName + Strings.DOT + fieldName));
		return tableAlias + Strings.DOT + "`" + columnCache.getColumn() + "`";
	}
	
	private static String formatKey(String key) {
        return key.toUpperCase(ENGLISH);
    }
	
	private static void createCache(TableInfo info) {
		String tableName = info.getTableName();
		if (info.havePK()) {
			cache.put(formatKey(tableName + Strings.DOT + info.getKeyProperty()), new ColumnCache(info.getKeyColumn(), info.getKeySqlSelect()));
		}
		info.getFieldList().forEach(i ->
			cache.put(formatKey(tableName + Strings.DOT + i.getProperty()), new ColumnCache(i.getColumn(), i.getSqlSelect()))
		);
	}
	
	public static String getTableName(SFunction<?, ?> column) {
//		SerializedLambda lambda = LambdaUtils.resolve(column);
//		Class<?> clazz = lambda.getInstantiatedType();

		Class<?> clazz = getClass(column);
		return getTableName(clazz);
	}
	
	public static String getTableName(Class<?> clazz) {
		TableInfo info = TableInfoHelper.getTableInfo(clazz);
		return  info.getTableName();
	}
}
