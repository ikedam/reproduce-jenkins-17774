/*
 * The MIT License
 * 
 * Copyright (c) 2013 IKEDA Yasuyuki
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.reproducejenkins17774;

import java.io.IOException;

import org.jvnet.hudson.test.Bug;
import org.jvnet.hudson.test.HudsonTestCase;
import org.xml.sax.SAXException;

/**
 * Test accessing to Jenkins via HTTP repeatedly.
 * 
 * This causes FileNotFoundException in Windows with TortoiseGit cache.
 * Refer to JENKINS-17774 for details.
 * 
 * What caused a failure will be recorded in target/surefire-reports/TEST-org.jenkinsci.plugins.reproducejenkins17774.Jesnkins17774Test.xml
 */
@Bug(17774)
public class Jesnkins17774Test extends HudsonTestCase
{
    private final int REPEAT = 30;
    
    public void testAccess() throws IOException, SAXException {
        WebClient wc = new WebClient();
        wc.goTo("");
    }
    
    @Override
    public void runBare() throws Throwable {
        System.out.println(String.format("===== Repeating %d Times %s.%s", REPEAT, getClass().getSimpleName(), getName()));
        for(int i = 1; i <= REPEAT; ++i) {
            System.out.println(String.format("= REPEAT %d/%d", i, REPEAT));
            super.runBare();
        }
    }
}
