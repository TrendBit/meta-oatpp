#############################################################################
#
# Project         _____    __   ____   _      _
#                (  _  )  /__\ (_  _)_| |_  _| |_
#                 )(_)(  /(__)\  )( (_   _)(_   _)
#                (_____)(__)(__)(__)  |_|    |_|
#
#
# Copyright 2021-present, Benedikt-Alexander Mokroß <github@bamkrs.de>
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
#############################################################################

DESCRIPTION = "Oat++ Swagger (OAS 3.0)" 
SECTION = "oatpp" 
LICENSE = "Apache-2.0" 
PR = "r0" 

DEPENDS = "oatpp"

SRC_URI = "git://github.com/oatpp/oatpp-swagger;branch=master;protocol=https"
SRCREV = "8cb460b546e84b06939a12897c85a6d863c1c53e"


LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

ALLOW_EMPTY:${PN} = "1"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

PACKAGECONFIG ??= ""

PACKAGECONFIG[shared] = "-DBUILD_SHARED_LIBS=ON,-DBUILD_SHARED_LIBS=OFF"
PACKAGECONFIG[tests] = "-DOATPP_BUILD_TESTS=ON,-DOATPP_BUILD_TESTS=OFF"

FILES:${PN}-staticdev = " \
    ${libdir}/oatpp-${PV}/liboatpp-swagger.a \ 
"



PACKAGES:prepend = "${PN}-ui "

INCDIR = "${includedir}/oatpp-${PV}/${PN}/${PN}"
CMDIR = "${libdir}/cmake/${PN}-${PV}"
FILES:${PN} = " \
    ${INCDIR}/AsyncController.hpp \
    ${INCDIR}/Controller.hpp \
    ${INCDIR}/Generator.hpp \
    ${INCDIR}/Model.hpp \
    ${INCDIR}/Resources.hpp \
    ${INCDIR}/Types.hpp \
    ${INCDIR}/oas3/Model.hpp \    
    ${CMDIR}/oatpp-swaggerConfig.cmake \
    ${CMDIR}/oatpp-swaggerConfigVersion.cmake \
    ${CMDIR}/oatpp-swaggerTargets.cmake \
    ${CMDIR}/oatpp-swaggerTargets-noconfig.cmake \
"
RESDIR = "${includedir}/oatpp-${PV}/bin/oatpp-swagger/res"
FILES:${PN}-ui = " \
    ${RESDIR}/swagger-ui.js.map \
    ${RESDIR}/swagger-ui-standalone-preset.js \
    ${RESDIR}/swagger-ui.css \
    ${RESDIR}/swagger-ui.js \
    ${RESDIR}/swagger-ui-es-bundle-core.js \
    ${RESDIR}/swagger-ui-es-bundle-core.js.map \
    ${RESDIR}/swagger-ui-bundle.js \
    ${RESDIR}/favicon-32x32.png \
    ${RESDIR}/favicon-16x16.png \
    ${RESDIR}/swagger-ui-es-bundle.js \
    ${RESDIR}/swagger-ui-es-bundle.js.map \
    ${RESDIR}/oauth2-redirect.html \
    ${RESDIR}/swagger-ui-standalone-preset.js.map \
    ${RESDIR}/index.css \
    ${RESDIR}/index.html \
    ${RESDIR}/swagger-initializer.js \
    ${RESDIR}/swagger-ui-bundle.js.map \
    ${RESDIR}/swagger-ui.css.map \
"
