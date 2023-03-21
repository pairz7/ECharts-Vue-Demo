<template>
  <div id="app" ref="app">
    <router-view/>
  </div>
</template>

<script>
import _ from 'lodash'
export default {
  name: 'App',
  mounted () {
    this.$nextTick(() => {
      const $app = this.$refs.app
      const standardScale = 1080 / 1920
      window.addEventListener(
        'resize',
        _.debounce(function () {
          const docHeight = document.body.clientHeight
          const docWidth = document.body.clientWidth

          if (docWidth < 1680) {
            const currentScale = docHeight / docWidth
            let [scale, translate] = [0, 0]
            if (currentScale < standardScale) {
              // 以高度计算
              scale = docHeight / 1080
              const shouleWidth = 1920 * scale
              const offsetWidth = docWidth - shouleWidth
              translate = offsetWidth > 0 ? `translate(${offsetWidth / 2}px, 0)` : ''
            } else {
              // 以宽度计算
              scale = docWidth / 1920
              const shouleHeight = 1080 * scale
              const offsetHeight = docHeight - shouleHeight
              translate = offsetHeight > 0 ? `translate(0, ${offsetHeight / 2}px)` : ''
            }
            console.log(translate)
            $app.style.cssText = `
            transform: scale(${scale}) ${translate};
            transform-origin: top left;
            min-width: 1920px;
            min-height: 1080px;
          `
          } else {
            $app.style.cssText = ''
          }
        }),
        200
      )

      if (document.createEvent) {
        var event = document.createEvent('HTMLEvents')
        event.initEvent('resize', true, true)
        window.dispatchEvent(event)
      } else if (document.createEventObject) {
        window.fireEvent('onresize')
      }
    })
  },
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
