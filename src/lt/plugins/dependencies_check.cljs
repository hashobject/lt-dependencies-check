(ns lt.plugins.dependencies-check
  (:require [lt.object :as object]
            [lt.objs.tabs :as tabs]
            [lt.objs.statusbar :as statusbar]
            [lt.objs.notifos :as notifos]
            [lt.util.js :as util]
            [clojure.edn :as edn])
  (:require-macros [lt.macros :refer [behavior]]))


(behavior :lt.objs.editor.file/on-save
          :triggers #{:save}
          :reaction (fn [this]
                      (let [project-def-str (lt.objs.editor/->val (lt.objs.editor.pool/last-active))
                            project-def nil]
                        (notifos/working "Checking dependencies..."))))


(object/object* ::worker
                :behaviors [:lt.objs.editor.file/on-save]
                :init (fn [this] (println this)))

(object/create ::worker)


