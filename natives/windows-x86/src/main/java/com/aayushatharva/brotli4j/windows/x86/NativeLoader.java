/*
 *    Copyright (c) 2020-2024, Aayush Atharva
 *
 *    Brotli4j licenses this file to you under the
 *    Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.aayushatharva.brotli4j.windows.x86;

import com.aayushatharva.brotli4j.service.BrotliNativeProvider;
import java.util.regex.Pattern;

/**
 * Service class to access the native lib in a JPMS context
 */
public class NativeLoader implements BrotliNativeProvider {

    @Override
    public String platformName() {
        return "windows-x86";
    }

    @Override
    public boolean isCurrentPlatform() {
        return Pattern.compile("windows( .*)?", Pattern.CASE_INSENSITIVE).matcher(System.getProperty("os.name")).matches() && "x86".equalsIgnoreCase(System.getProperty("os.arch"));
    }
}