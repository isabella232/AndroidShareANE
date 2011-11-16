set adt_directory=C:\Program Files (x86)\Adobe\Adobe Flash Builder 4.6\sdks\4.6.0\bin
set root_directory=D:\projects
set library_directory=%root_directory%\share
set native_directory=%root_directory%\share
set signing_options=-storetype pkcs12 -keystore "D:\projects\share\cert.p12" -storepass m0rr!$2113
set dest_ANE=ShareANE.ane
set extension_XML=%library_directory%\extension.xml
set library_SWC=%library_directory%\ShareTest.swc
"%adt_directory%"/adt  -package -tsa none %signing_options% -target ane "%dest_ANE%" "%extension_XML%" -swc "%library_SWC%" -platform Android-ARM -C "%native_directory%" library.swf ShareExtension.jar 
