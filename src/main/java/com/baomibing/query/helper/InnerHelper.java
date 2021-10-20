/**
 * Copyright (c) 2021-2021, zening (316279828@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomibing.query.helper;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

import com.baomibing.query.SQLQuery;
/**
 * System inner util helper
 * 
 * @author zening
 * @data 2021-10-20 11:42:20
 * @since 1.0.0
 */
public abstract class InnerHelper {
	
	public static void main(String[] args) {
		String string = "im he ' some of charts '";
		string = string.replaceAll("'", "'''");
		System.out.println(string);
	}
	
	
    public static int offsetCurrent(int current, int size) {
        if (current > 0) {
            return (current - 1) * size;
        }
        return 0;
    }
	
	public static String format(String s, Object... args) {
		if (ArrayUtils.isNotEmpty(args)) {
			for (Object o : args) {
				if (o instanceof String) {
					String os = (String)o;
					os = os.replaceAll("'", "'''");
				}
			}
		}
		return MessageFormat.format(s, args);
	}

	public static  Object displayValue(Object value) {
		if (value == null) {
			return null;
		}
		Class<?> type = value.getClass();
		if (SQLQuery.class.equals(type)) {
			return ((SQLQuery) value).toSQL();
		}
		if (type.isPrimitive()) {
			if (boolean.class.equals(type)) {
				type = Boolean.class;
			} else if (char.class.equals(type)) {
				type = Character.class;
			} else if (byte.class.equals(type)) {
				type = Byte.class;
			} else if (short.class.equals(type)) {
				type = Short.class;
			} else if (int.class.equals(type)) {
				type = Integer.class;
			} else if (long.class.equals(type)) {
				type = Long.class;
			} else if (float.class.equals(type)) {
				type = Float.class;
			} else if (double.class.equals(type)) {
				type = Double.class;
			}
		}
		if (String.class.equals(type))
			return "'" + value.toString() + "'";
		if (Number.class.isAssignableFrom(type)) {
			if (value instanceof Number) {
				Number num = (Number) value;
				if (type.equals(Double.class))
					return new Double(num.doubleValue());
				if (type.equals(Float.class))
					return new Float(num.floatValue());
				if (type.equals(Long.class))
					return new Long(num.longValue());
				if (type.equals(Integer.class))
					return new Integer(num.intValue());
				if (type.equals(Short.class))
					return new Short(num.shortValue());
				try {
					return type.getConstructor(new Class[] { String.class })
							.newInstance(new Object[] { value.toString() });
				} catch (IllegalArgumentException e) {

				} catch (SecurityException e) {

				} catch (InstantiationException e) {

				} catch (IllegalAccessException e) {

				} catch (InvocationTargetException e) {

				} catch (NoSuchMethodException e) {
				}
			} else if (value instanceof String) {
				try {
					if (type.equals(Double.class))
						return Double.valueOf(Double.parseDouble((String) value));
					if (type.equals(Float.class))
						return Float.valueOf(Float.parseFloat((String) value));
					if (type.equals(Long.class))
						return Long.valueOf(Long.parseLong((String) value));
					if (type.equals(Integer.class))
						return Integer.valueOf(Integer.parseInt((String) value));
					if (type.equals(Short.class))
						return Short.valueOf(Short.parseShort((String) value));
					if (type.equals(Byte.class))
						return Byte.valueOf(Byte.parseByte((String) value));
				} catch (NumberFormatException ex) {
				}
			}
		} else if (Class.class.equals(type)) {
			try {
				return Class.forName(value.toString());
			} catch (ClassNotFoundException e) {
				throw new ClassCastException("Unable to convert value " + value.toString() + " to type Class");
			}
		} else if (java.util.Collection.class.isAssignableFrom(type)) {
			Collection<?> collection = (Collection<?>) value;
			return collection.stream().map(c -> displayValue(c).toString())
					.collect(Collectors.joining(","));
		} else if (value instanceof Object[]) {
			return Arrays.stream((Object[])value).map(c -> displayValue(c).toString())
					.collect(Collectors.joining(","));
		}
		throw new ClassCastException(
				"Unable to convert value of type " + value.getClass().getName() + " to type " + type.getName());
	}
}
