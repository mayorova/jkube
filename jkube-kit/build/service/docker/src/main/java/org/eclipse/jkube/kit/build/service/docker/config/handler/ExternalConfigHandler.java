/**
 * Copyright (c) 2019 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at:
 *
 *     https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.jkube.kit.build.service.docker.config.handler;

import java.util.List;

import org.eclipse.jkube.kit.build.service.docker.ImageConfiguration;
import org.eclipse.jkube.kit.common.JkubeProject;

/**
 * Interface which needs to be implemented to create
 * image configurations from external sources
 *
 * @author roland
 * @since 18/11/14
 */
public interface ExternalConfigHandler {

    /**
     * Get the unique type of this plugin as referenced with the <code>&lt;type&gt;</code> tag within a
     * <code>&lt;reference&gt;</code> configuration section
     *
     * @return plugin type
     */
    String getType();

    /**
     * For the given plugin configuration (which also contains the type) extract one or more
     * {@link ImageConfiguration} objects describing the image to manage
     *
     * @param unresolvedConfig the original, unresolved config
     * @param project project
     * @return list of image configuration. Must not be null but can be empty.
     * @throws ExternalConfigHandlerException if there is a problem resolving the image configuration
     */
    List<ImageConfiguration> resolve(ImageConfiguration unresolvedConfig, JkubeProject project)
        throws ExternalConfigHandlerException;
}
