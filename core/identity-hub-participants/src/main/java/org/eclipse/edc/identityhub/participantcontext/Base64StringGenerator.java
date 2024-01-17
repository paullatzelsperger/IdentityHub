/*
 *  Copyright (c) 2024 Metaform Systems, Inc.
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Metaform Systems, Inc. - initial API and implementation
 *
 */

package org.eclipse.edc.identityhub.participantcontext;

import org.eclipse.edc.identityhub.spi.RandomStringGenerator;

import java.security.SecureRandom;
import java.util.Base64;

/**
 * Generates a random string using a bounded array and a secure random. The result is returned in base64 encoded form.
 * The bound is the length of the randomly generated byte array, which is later encoded, so the result will be longer!
 */
public class Base64StringGenerator implements RandomStringGenerator {
    private final SecureRandom secureRandom = new SecureRandom();
    private final int bound;

    /**
     * Instantiates this generator with the given bound.
     *
     * @param bound the length of the byte array that is filled with random data
     */
    public Base64StringGenerator(int bound) {
        this.bound = bound;
    }

    /**
     * Instantiates this generator with a default bound of 64.
     */
    public Base64StringGenerator() {
        this.bound = 64;
    }

    @Override
    public String generate() {
        byte[] array = new byte[bound];
        secureRandom.nextBytes(array);
        var enc = Base64.getEncoder();
        return enc.encodeToString(array);

    }
}
