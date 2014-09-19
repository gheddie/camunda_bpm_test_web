my $componentId = "test_vb";
my $componentState = "OPEN";
my $classpath = "/usr/local/homeauth/ws_lib/bpm-client-1.0-SNAPSHOT.jar:/usr/local/homeauth/ws_lib/cxf-bundle-2.7.12.jar:/usr/local/homeauth/ws_lib/xmlschema-core-2.1.0.jar:/usr/local/homeauth/ws_lib/wsdl4j-1.6.3.jar:/usr/local/homeauth/ws_lib/bpm-ejb-1.0-SNAPSHOT.jar:/usr/local/homeauth/ws_lib/neethi-3.0.3.jar:/usr/local/homeauth/ws_lib/asm-3.3.1.jar:/usr/local/homeauth/ws_lib/commons-cli-1.2.jar";
$cmd = "java -cp $classpath de.gravitex.bpmtest.PerlWebServiceConnector -componentId $componentId -componentState $componentState";
system($cmd);