/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2023 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wildfly.plugin.dev;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
class CompiledSourceHandler implements WatchHandler {

    @Override
    public Result handle(final WatchContext context, final WatchEvent<Path> event, final Path file)
            throws IOException, MojoExecutionException {
        return new Result() {
            @Override
            public boolean requiresRecompile() {
                return true;
            }

            @Override
            public boolean requiresRedeploy() {
                return true;
            }

            @Override
            public boolean requiresRepackage() {
                return true;
            }
        };
    }
}
