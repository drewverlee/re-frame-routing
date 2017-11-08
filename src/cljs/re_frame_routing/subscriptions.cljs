(ns re-frame-routing.subscriptions
  (:require [re-frame.core :as re-frame]))

(defn register-subscriptions
  "Register re-frame-routing subscriptions"
  []

  (re-frame/reg-sub
   :router/core
   (fn [{:keys [router]} _] router))

  (re-frame/reg-sub
   :router/route
   (fn [_ _] (re-frame/subscribe [:router/core]))
   (fn [{:keys [route]} _] route))

  (re-frame/reg-sub
   :router/route-params
   (fn [_ _] (re-frame/subscribe [:router/core]))
   (fn [{:keys [route-params]} _] route-params)))
