/**
 * 
 *Copyright 2014 The Darks Logs Project
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

package darks.log.pattern.parser;

import darks.log.LogMessage;

/**
 * Format cost time by pattern
 * 
 * DuringTimePatternConvertor.java
 * 
 * @version 1.0.0
 * @author Liu lihua
 */
public class DuringTimePatternConvertor extends PatternConvertor
{

    public DuringTimePatternConvertor()
    {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean format(StringBuilder buf, LogMessage message)
    {
        if (message == null || message.getTimeStamp() <= 0)
        {
            return false;
        }
        long st = LogMessage.getStartupTime();
        long during = message.getTimeStamp() - st;
        buf.append(during);
        return true;
    }

}
