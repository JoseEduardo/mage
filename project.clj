(defproject xmage "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[com.h2database/h2 "1.4.187"]
                 [com.j256.ormlite/ormlite-jdbc "4.48"]
                 [com.google.protobuf/protobuf-java "3.0.0-beta-1"]
                 [org.jboss.remoting/jboss-remoting "2.5.4.SP5"]
                 [org.jboss/jboss-common-core "2.2.22.GA"]
                 [trove/trove "1.0.2"]
                 [org.apache.shiro/shiro-core "1.2.4"]
                 [log4j/log4j "1.2.12"]
                 [org.apache.commons/commons-lang3 "3.3.2"]
                 [com.google.api-client/google-api-client "1.21.0"]
                 [com.sun.xml.bind/jaxb-impl "2.1.17"]
                 [com.googlecode.jspf/jspf-core "0.9.1"]
                 [org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot xmage.core
  :target-path "target/%s"
  :resource-paths [
                   "Mage/target/mage.jar"
                   "Mage.Sets/target/mage-sets.jar"
                   "Mage.Common/target/mage-common.jar"
                   ]
  :java-source-paths [
                      "Mage/src/main/java"
                      "Mage.Common/src/main/java"

                      ;; "Mage.Plugins/src/main/java"
                      ;; "Mage.Server/src/main/java"
                      ;; "Mage.Server.Console/src/main/java"
                      ;; "Mage.Server.Plugins/src/main/java"
                      ;; "Mage.Sets/src/main/java"
                      ;; "Mage.Stats/src/main/java"
                      ;; "Mage.Tests/src/main/java"
                      ;; "Mage.Updater/src/main/java"
                      ;; "Mage.Verify/src/main/java"
                      ]
  :profiles {:uberjar {:aot :all}})

