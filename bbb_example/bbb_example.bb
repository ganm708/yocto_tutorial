SUMMARY = "Example to learn how build task work"

LICENSE = "MIT"

LICENSE_FILES_CHECKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/ganm708/yocto_tutorial.git;protocol=https;branch=main;rev=586ecb54b5092e20bc96c1ada396ca81b5585cf2"
#SRCREV = "586ecb54b5092e20bc96c1ada396ca81b5585cf2"

#SRC_URI:append = " file://0001-patch-example.patch"

S = "${WORKDIR}/git"

do_configure(){
    echo "define Welcome y" > bbb-example.h
}

do_compile(){
    ${CC} ${CFLAGS} ${LDFLAGS} ${S}/bbb-example.c -o bbb-example
}

do_install(){
    install -d ${D}${bindir}
    install -m 0755 bbb-example ${D}${bindir}/
}


# * **Fetch** (do_fetch) :   Fetches the source code
# * **Unpack** (do_upack) : Unpacks the source code into a working directory
# * **Patch** (do_patch) : Locates patch files and applies them to the source code
# * **Configure** (do_configure) : Configures the source by enabling and disabling any build-time and configuration options for the software being built.
# * **Compile** (do_compile) : Compiles the source in the compilation directory
# * **Install** (do_install) : Copies files from the compilation directory to a holding area