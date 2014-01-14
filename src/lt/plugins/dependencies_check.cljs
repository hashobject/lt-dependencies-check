(ns lt.plugins.dependencies-check
  (:require [lt.object :as object]
            [lt.objs.tabs :as tabs]
            [lt.objs.statusbar :as statusbar]
            [lt.objs.notifos :as notifos]
            [lt.util.js :as util])
  (:require-macros [lt.macros :refer [behavior defui]]))


(behavior ::on-save
          :triggers #{:save}
          :reaction (fn [this]
                      (notifos/working "Hello anton5")))



(object/object* ::worker
                :behaviors [::on-save]
                :init (fn [this] (println this)))



(object/create ::worker)




;(lt.objs.editor/->val (lt.objs.editor.pool/last-active))


