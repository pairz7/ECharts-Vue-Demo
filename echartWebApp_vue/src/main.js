// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI)
import * as echarts from 'echarts';
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
import 'lib-flexible/flexible'
import rem from './util/rem'
/* eslint-disable no-new */
import axios from 'axios'
import VueAxios from 'vue-axios'
Vue.use(VueAxios,axios)
Vue.prototype.$server='http://120.25.192.156/echartAPI';
Vue.prototype.$axios=axios;
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
