package com.mnubo.java.sdk.client.config;

import static com.mnubo.java.sdk.client.Constants.*;
import static com.mnubo.java.sdk.client.config.MnuboSDKConfig.Builder.*;
import static com.mnubo.java.sdk.client.config.MnuboSDKConfig.DEFAULT_SCOPE;
import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MnuboSDKConfigTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private Map<String, Map<String, String>> fieldList = new HashMap<String, Map<String, String>>() {{
        put(HOST_NAME, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", HOST_NAME));
            put("", format("%s property has to be a valid String.", HOST_NAME));
        }});
        put(SECURITY_CONSUMER_KEY, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", SECURITY_CONSUMER_KEY));
            put("", format("%s property has to be a valid String.", SECURITY_CONSUMER_KEY));
        }});
        put(SECURITY_CONSUMER_SECRET, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", SECURITY_CONSUMER_SECRET));
            put("", format("%s property has to be a valid String.", SECURITY_CONSUMER_SECRET));
        }});
        put(CLIENT_BASE_PATH, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_BASE_PATH));
            put("", format("%s property has to be a valid String.", CLIENT_BASE_PATH));
        }});
        put(INGESTION_PORT, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", INGESTION_PORT));
            put("", format("%s property has to be a valid String.", INGESTION_PORT));
            put("54d", format("%s property has to be an positive integer.", INGESTION_PORT));
            put("0", format("%s property has to be a valid port.", INGESTION_PORT));
            put("-10", format("%s property has to be an positive integer.", INGESTION_PORT));
            put("9999999", format("%s property has to be a valid port.", INGESTION_PORT));
        }});
        put(RESTITUTION_PORT, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", RESTITUTION_PORT));
            put("", format("%s property has to be a valid String.", RESTITUTION_PORT));
            put("54d", format("%s property has to be an positive integer.", RESTITUTION_PORT));
            put("0", format("%s property has to be a valid port.", RESTITUTION_PORT));
            put("-10", format("%s property has to be an positive integer.", RESTITUTION_PORT));
            put("9999999", format("%s property has to be a valid port.", RESTITUTION_PORT));
        }});
        put(AUTHENTICATION_PORT, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", AUTHENTICATION_PORT));
            put("", format("%s property has to be a valid String.", AUTHENTICATION_PORT));
            put("54d", format("%s property has to be an positive integer.", AUTHENTICATION_PORT));
            put("0", format("%s property has to be a valid port.", AUTHENTICATION_PORT));
            put("-10", format("%s property has to be an positive integer.", AUTHENTICATION_PORT));
            put("9999999", format("%s property has to be a valid port.", AUTHENTICATION_PORT));
        }});
        put(CLIENT_DISABLE_REDIRECT_HANDLING, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_DISABLE_REDIRECT_HANDLING));
            put("", format("%s property has to be a valid String.", CLIENT_DISABLE_REDIRECT_HANDLING));
            put("maybe", format("%s property has to be a boolean valid.", CLIENT_DISABLE_REDIRECT_HANDLING));
        }});
        put(CLIENT_DISABLE_AUTOMATIC_RETRIES, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_DISABLE_AUTOMATIC_RETRIES));
            put("", format("%s property has to be a valid String.", CLIENT_DISABLE_AUTOMATIC_RETRIES));
            put("maybe", format("%s property has to be a boolean valid.", CLIENT_DISABLE_AUTOMATIC_RETRIES));
        }});
        put(CLIENT_DISABLE_CONTENT_COMPRESSION, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_DISABLE_CONTENT_COMPRESSION));
            put("", format("%s property has to be a valid String.", CLIENT_DISABLE_CONTENT_COMPRESSION));
            put("maybe", format("%s property has to be a boolean valid.", CLIENT_DISABLE_CONTENT_COMPRESSION));
        }});
        put(CLIENT_MAX_CONNECTIONS_PER_ROUTE, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_MAX_CONNECTIONS_PER_ROUTE));
            put("", format("%s property has to be a valid String.", CLIENT_MAX_CONNECTIONS_PER_ROUTE));
            put("54d", format("%s property has to be an positive integer.", CLIENT_MAX_CONNECTIONS_PER_ROUTE));
            put("-10", format("%s property has to be an positive integer.", CLIENT_MAX_CONNECTIONS_PER_ROUTE));
        }});
        put(CLIENT_DEFAULT_TIMEOUT, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_DEFAULT_TIMEOUT));
            put("", format("%s property has to be a valid String.", CLIENT_DEFAULT_TIMEOUT));
            put("54d", format("%s property has to be an positive integer.", CLIENT_DEFAULT_TIMEOUT));
            put("-10", format("%s property has to be an positive integer.", CLIENT_DEFAULT_TIMEOUT));
        }});
        put(CLIENT_CONNECT_TIMEOUT, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_CONNECT_TIMEOUT));
            put("", format("%s property has to be a valid String.", CLIENT_CONNECT_TIMEOUT));
            put("54d", format("%s property has to be an positive integer.", CLIENT_CONNECT_TIMEOUT));
            put("-10", format("%s property has to be an positive integer.", CLIENT_CONNECT_TIMEOUT));
        }});
        put(CLIENT_CONNECTION_REQUEST_TIMEOUT, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_CONNECTION_REQUEST_TIMEOUT));
            put("", format("%s property has to be a valid String.", CLIENT_CONNECTION_REQUEST_TIMEOUT));
            put("54d", format("%s property has to be an positive integer.", CLIENT_CONNECTION_REQUEST_TIMEOUT));
            put("-10", format("%s property has to be an positive integer.", CLIENT_CONNECTION_REQUEST_TIMEOUT));
        }});
        put(CLIENT_SOCKET_TIMEOUT, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_SOCKET_TIMEOUT));
            put("", format("%s property has to be a valid String.", CLIENT_SOCKET_TIMEOUT));
            put("54d", format("%s property has to be an positive integer.", CLIENT_SOCKET_TIMEOUT));
            put("-10", format("%s property has to be an positive integer.", CLIENT_SOCKET_TIMEOUT));
        }});
        put(CLIENT_MAX_TOTAL_CONNECTION, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", CLIENT_MAX_TOTAL_CONNECTION));
            put("", format("%s property has to be a valid String.", CLIENT_MAX_TOTAL_CONNECTION));
            put("54d", format("%s property has to be an positive integer.", CLIENT_MAX_TOTAL_CONNECTION));
            put("-10", format("%s property has to be an positive integer.", CLIENT_MAX_TOTAL_CONNECTION));
        }});
        put(HTTP_PROTOCOL, new HashMap<String, String>() {{
            put(null, format("%s property has to be a valid String.", HTTP_PROTOCOL));
            put("", format("%s property has to be a valid String.", HTTP_PROTOCOL));
            put("ftp", format("%s has to be equal to \"http\" or \"https\"", HTTP_PROTOCOL));
        }});
    }};

    @Test
    public void defaultConfig() {
        MnuboSDKConfig config = MnuboSDKConfig.builder().withHostName("host").withSecurityConsumerKey("CK")
                .withSecurityConsumerSecret("CS").build();

        assertThat(config.getHostName(), is(equalTo("host")));
        assertThat(config.getSecurityConsumerKey(), is(equalTo("CK")));
        assertThat(config.getSecurityConsumerSecret(), is(equalTo("CS")));
        assertThat(config.getAuthenticationPort(), is(equalTo(DEFAULT_HOST_PORT)));
        assertThat(config.getHttpBasePath(), is(equalTo(DEFAULT_BASE_PATH)));
        assertThat(config.getHttpConnectionRequestTimeout(), is(equalTo(DEFAULT_TIMEOUT)));
        assertThat(config.getHttpDefaultTimeout(), is(equalTo(DEFAULT_TIMEOUT)));
        assertThat(config.getHttpMaxConnectionPerRoute(), is(equalTo(DEFAULT_MAX_CONNECTIONS_PER_ROUTE)));
        assertThat(config.getHttpMaxTotalConnection(), is(equalTo(DEFAULT_MAX_TOTAL_CONNECTIONS)));
        assertThat(config.getHttpProtocol(), is(equalTo(DEFAULT_CLIENT_PROTOCOL)));
        assertThat(config.getHttpSoketTimeout(), is(equalTo(DEFAULT_TIMEOUT)));
        assertThat(config.getPlatformPort(), is(equalTo(DEFAULT_HOST_PORT)));
        assertThat(config.getRestitutionPort(), is(equalTo(DEFAULT_HOST_PORT)));
        assertThat(config.getScope(), is(equalTo(DEFAULT_SCOPE)));
        assertThat(config.isHttpDisableContentCompression(), is(equalTo(DEFAULT_DISABLE_CONTENT_COMPRESSION)));
    }

    @Test
    public void customConfig() {
        MnuboSDKConfig config = MnuboSDKConfig.builder().withHostName("host").withSecurityConsumerKey("CK")
                                              .withSecurityConsumerSecret("CS").withIngestionPort("1111").withHttpBasePath("/yyy/iii")
                                              .withHttpProtocol("http").withHttpConnectionRequestTimeout("20").withHttpSocketTimeout("500")
                                              .withRestitutionPort("2222")
                                              .withHttpDisableContentCompression("true").build();

        assertThat(config.getHostName(), is(equalTo("host")));
        assertThat(config.getSecurityConsumerKey(), is(equalTo("CK")));
        assertThat(config.getSecurityConsumerSecret(), is(equalTo("CS")));
        assertThat(config.getAuthenticationPort(), is(equalTo(DEFAULT_HOST_PORT)));
        assertThat(config.getHttpBasePath(), is(equalTo("/yyy/iii")));
        assertThat(config.getHttpConnectionRequestTimeout(), is(equalTo(20)));
        assertThat(config.getHttpDefaultTimeout(), is(equalTo(DEFAULT_TIMEOUT)));
        assertThat(config.getHttpMaxConnectionPerRoute(), is(equalTo(DEFAULT_MAX_CONNECTIONS_PER_ROUTE)));
        assertThat(config.getHttpMaxTotalConnection(), is(equalTo(DEFAULT_MAX_TOTAL_CONNECTIONS)));
        assertThat(config.getHttpProtocol(), is(equalTo("http")));
        assertThat(config.getHttpSoketTimeout(), is(equalTo(500)));
        assertThat(config.getPlatformPort(), is(equalTo(1111)));
        assertThat(config.getRestitutionPort(), is(equalTo(2222)));
        assertThat(config.getScope(), is(equalTo(DEFAULT_SCOPE)));
        assertThat(config.isHttpDisableContentCompression(), is(equalTo(true)));
    }

    @Test
    public void configBuilderValidator() throws Exception {

        for(Map.Entry<String, Map<String, String>> field : fieldList.entrySet()) {

            String fieldName = field.getKey();
            Map<String, String> userCases = field.getValue();

            for(Map.Entry<String, String> userCase : userCases.entrySet()) {

                String userCaseValue = userCase.getKey();
                String errorMessage = userCase.getValue();

                try {

                    configBuilderExecutor(fieldName, userCaseValue);

                } catch (IllegalStateException ex) {

                    assertThat(ex.getMessage(), is(equalTo(errorMessage)));
                }
            }
        }
    }

    private void configBuilderExecutor(String field, String value) throws Exception {

        MnuboSDKConfig.Builder config = MnuboSDKConfig.builder();

        switch (field) {
            case HOST_NAME:
                config.withHostName(value);
                break;
            case INGESTION_PORT:
                config.withIngestionPort(value);
                break;
            case RESTITUTION_PORT:
                config.withRestitutionPort(value);
                break;
            case AUTHENTICATION_PORT:
                config.withAuthenticationPort(value);
                break;
            case SECURITY_CONSUMER_KEY:
                config.withSecurityConsumerKey(value);
                break;
            case SECURITY_CONSUMER_SECRET:
                config.withSecurityConsumerSecret(value);
                break;
            case HTTP_PROTOCOL:
                config.withHttpProtocol(value);
                break;
            case CLIENT_DISABLE_REDIRECT_HANDLING:
                config.withHttpDisableRedirectHandling(value);
                break;
            case CLIENT_DISABLE_AUTOMATIC_RETRIES:
                config.withHttpDisableAutomaticRetries(value);
                break;
            case CLIENT_DISABLE_CONTENT_COMPRESSION:
                config.withHttpDisableContentCompression(value);
                break;
            case CLIENT_MAX_CONNECTIONS_PER_ROUTE:
                config.withHttpMaxConnectionPerRoute(value);
                break;
            case CLIENT_DEFAULT_TIMEOUT:
                config.withHttpDefaultTimeout(value);
                break;
            case CLIENT_CONNECT_TIMEOUT:
                config.withHttpConnectionTimeout(value);
                break;
            case CLIENT_CONNECTION_REQUEST_TIMEOUT:
                config.withHttpConnectionRequestTimeout(value);
                break;
            case CLIENT_SOCKET_TIMEOUT:
                config.withHttpSocketTimeout(value);
                break;
            case CLIENT_MAX_TOTAL_CONNECTION:
                config.withHttpMaxTotalConnection(value);
                break;
            case CLIENT_BASE_PATH:
                config.withHttpBasePath(value);
                break;
        }
        fail(format("field: %s, value: %s", field, value));
    }
}

