package Logger;

import org.apache.log4j.Logger;

public class BBMSLogger 
{
	final static Logger logger = Logger.getLogger(BBMSLogger.class);
	
	public static void LogInfo(Object message)
	{
			logger.info(message);
	}

	public static void LogDebug(Object message)
	{
			logger.debug(message);
	}
	
	public static void LogError(Object message)
	{
			logger.error(message);
	}

	
	public static void LogWarn(Object message)
	{
			logger.warn(message);
	}
}
