package com.stockwiz.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextUtils
{
	public enum	FormatType {
		MILLIONS,
		RATIO,
		CENTS,
		PERCENT,
		INTEGER,
		DECIMAL
	}

	public static Object parse (String text, FormatType fmt)	{
		try	{
			if (text != null)	{
				if (!text.equals("-") && text.length() > 0)	{
					switch (fmt)	{
						case MILLIONS:
							char last = text.charAt(text.length()-1);
							switch (last)	{
								case 'B': return Float.parseFloat(text.substring(0, text.length() - 1)) * 1000;
								case 'M': return Float.parseFloat(text.substring(0, text.length() - 1));
								default: return 0;
							}
						case RATIO:
							return Float.parseFloat(text);
						case CENTS:
							return (int) (Float.parseFloat(text) * 100);
						case PERCENT:
							return Float.parseFloat(text.substring(0, text.length()-1)) / 100;
						case INTEGER:
							return Integer.parseInt(text);
						case DECIMAL:
							return Float.parseFloat(text);
					}
				}
			}
		} catch (NumberFormatException nfe)	{
			log.error("TextUtils.parse("+text+","+fmt+")", nfe);
		}
		return null;
	}

	public static Integer parseMillions (String text) { return (Integer) parse (text, FormatType.MILLIONS); }
	public static Float parseRatio (String text) { return (Float) parse (text, FormatType.RATIO); }
	public static Float parsePercentage (String text) { return (Float) parse (text, FormatType.PERCENT); }
	public static Integer parseCents (String text) { return (Integer) parse (text, FormatType.CENTS); }
	public static Integer parseInteger (String text) { return (Integer) parse (text, FormatType.INTEGER); }
	public static Float parseFloat (String text) { return (Float) parse (text, FormatType.DECIMAL); }
}