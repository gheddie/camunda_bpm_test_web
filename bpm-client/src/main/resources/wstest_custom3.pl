use SOAP::Lite;
my $lite = SOAP::Lite -> service('http://192.168.0.5:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl');
$lite->triggerWebserviceSimple();