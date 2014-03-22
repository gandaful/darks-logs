/**
 * 
 *Copyright 2014 The Darks Logs Project (Liu lihua)
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */

package darks.log.appender.impl;

import darks.log.Level;
import darks.log.LogMessage;
import darks.log.appender.Appender;

/**
 * Appender for system console. The appender wiil output log message in command
 * console. <br>
 * Example:
 * 
 * <pre>
 *  logd.appender.console=ConsoleAppender
 *  logd.appender.console.layout=PatternLayout
 *  logd.appender.console.layout.convertor=DefaultPattern
 *  logd.appender.console.layout.pattern=%d{yyyy-MM-dd HH:mm:ss} [%f][%p] - %m%n
 * </pre>
 * 
 * ConsoleAppender.java
 * 
 * @see Appender
 * @version 1.0.0
 * @author Liu lihua
 */
public class ConsoleAppender extends Appender
{

    public ConsoleAppender()
    {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void append(LogMessage msg, String log) throws Exception
    {
        if (msg.getLevel().equals(Level.ERROR))
        {
            Throwable e = msg.getThrowableInfo().getThrowable();
            System.err.print(getThrowMessage(log, e));
        }
        else
        {
            Throwable e = msg.getThrowableInfo().getThrowable();
            System.out.print(getThrowMessage(log, e));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean needPattern()
    {
        return true;
    }

}
