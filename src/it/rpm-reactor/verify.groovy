// $Id$
import org.codehaus.mojo.unix.rpm.RpmUtil
import org.codehaus.mojo.unix.rpm.RpmUtil.FileInfo
import org.codehaus.mojo.unix.rpm.RpmUtil.SpecFile

import java.io.*
import java.util.List
import java.util.Iterator


File jar = new File((File) basedir, "rpm-jar/target/rpm-reactor-module-jar-1.0.jar")
if (!jar.exists())
    throw new java.lang.AssertionError("jar file does not exist: " + jar.getAbsolutePath());

File war = new File((File) basedir, "rpm-war/target/rpm-reactor-module-war-1.0.war")
if (!war.exists())
    throw new java.lang.AssertionError("war file does not exist: " + war.getAbsolutePath());

File rpm = new File((File) basedir, "rpm-rpm/target/rpm/rpm-reactor-module-rpm/RPMS/noarch/rpm-reactor-module-rpm-1.0-rel.noarch.rpm")
if (!rpm.exists())
    throw new java.lang.AssertionError("rpm file does not exist: " + rpm.getAbsolutePath());

SpecFile spec = RpmUtil.getSpecFileFromRpm(rpm)

List fileInfos = RpmUtil.queryPackageForFileInfo(rpm)

int fileCnt = fileInfos.size()
System.out.println("File Count: " + fileCnt);
System.out.println(fileInfos);

if (fileCnt != 1)
    throw new java.lang.AssertionError("number of files in rpm: " + fileCnt + "does not match expected: 1");

return true
