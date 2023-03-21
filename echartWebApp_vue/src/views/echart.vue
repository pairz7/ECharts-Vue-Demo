<template>
  <div class="mainland">
    <div class="mylink position1" onclick="window.open('http://self.pair7z.com')">
      我的主页
    </div>
    <div class="mylink position2" onclick="alert('敬请期待')">
      Github项目
    </div>
    <el-main>
      <div class="intro">
        <h1 class="myhead">Introduction</h1>
        <p style="float: right">2022年12月09日</p>
        <div class="para">
          <p><b>大数据技术实验</b>  Echarts学习</p>
          <p>Hi,这是我的本科课程『大数据技术』实验4的成果呈现,本次实验的主要内容是学习使用Echarts. </p>
          <p>感谢官方文档的帮助,通过实现Part1中的demo可以快速上手Echarts.此外我还实现了三个好玩的案例来深入学习Echarts.</p>
          <p>本次实验所使用的技术栈: <a href="https://echarts.apache.org/zh/index.html" target="_blank">Echarts</a>&nbsp;&nbsp;<a href="https://cn.vuejs.org/" target="_blank">Vue.js</a>&nbsp;&nbsp;
            <a href="https://element.eleme.cn/" target="_blank">Element-UI</a>&nbsp;&nbsp;
            <a href="https://spring.io/projects/spring-boot" target="_blank">Springboot</a>
          </p>
        </div>
      </div>
      <div style="margin-top: 20px;">
        <el-collapse v-model="activeName" accordion>
          <el-collapse-item title="Part1. My First Chart" name="1">
            <div class="Echarts">
              <div id="main" class="mains"></div>
            </div>
            <div>实现了demo后,我们来做一些好玩的案例 <el-button type="text" @click="activeName='2'">Continue</el-button></div>
          </el-collapse-item>
          <el-collapse-item title="Part2. 进阶案例" name="2">
            <div class="" style="">
              <div id="secondEchart" class="second"/>
              <div>数据来源于互联网</div>
              <div>静态的图表显然不能满足我们的业务需求 <el-button type="text" @click="activeName='3'">Continue</el-button></div>
            </div>
          </el-collapse-item>
          <el-collapse-item title="Part3. 交互式图表" name="3">
            <div>实现可交互式图表,通过前端控件与图表进行交互</div>
            <el-row>
              <el-col :span="18">
                <div class="third" style="">
                  <div id="thirdChart" class=""/>
                </div>
              </el-col>
              <el-col :span="6" style="font-size: 18px">
                y=<el-input size="mini" style="width: 50px" v-model="aa" />x<sup>3</sup> +
                <el-input size="mini" style="width: 50px" v-model="bb" />x<sup>2</sup> +
                <el-input size="mini" style="width: 50px" v-model="cc" />x +
                <el-input size="mini" style="width: 80px" v-model="myd" />
              </el-col>
            </el-row>

            <el-button type="text" @click="activeName='4'">Continue</el-button>
          </el-collapse-item>
          <el-collapse-item title="Part4. 数据库驱动的图表" name="4">
            <div>通常在我们的实际业务中,图表的数据是动态的,因此本版块的Chart是连接后端数据库的,并且可以实时更改</div>
            <el-row>
              <el-col :span="16">
                <div class="forth">
                  <div id="forthChart">
                  </div>
                </div>
              </el-col>
              <el-col :span="8" style="margin-top: 200px">
                <div style="margin-bottom: 10px">
                  欢迎各位老板入股
                </div>
                <div>
                  股东名称:<el-input style="width: 150px" v-model="newShareholder.name"></el-input>
                  股份:<el-input-number style="width: 120px" v-model="newShareholder.value"></el-input-number>万元
                  <el-button type="primary" size="small" @click="handleAddShareholder">增加股东</el-button>
                </div>
                <div style="margin-top: 20px">
                  查看股东
                  <el-select v-model="selectShareholder" placeholder="请选择股东" style="width: 150px">
                    <el-option v-for="item in shareholders" :value="item" :key="item" :label="item.name">

                    </el-option>
                  </el-select>
                  <el-input-number style="width: 120px" v-model="selectShareholder.value"></el-input-number>万元<el-button size="small" type="warning" @click="handleModifyShareholder">修改股份</el-button>
                  <el-button type="danger" size="small" @click="handleDelShareholder">删除股东</el-button>
                </div>
              </el-col>
            </el-row>


            <el-button type="text" @click="activeName='1'">重新开始</el-button>
          </el-collapse-item>

        </el-collapse>

      </div>
      <el-divider></el-divider>
    </el-main>
    <el-footer>
      <myfooter></myfooter>
    </el-footer>
  </div>
</template>

<script>
import Myfooter from "../components/myfooter";
import axios from 'axios';
export default {
  name: 'echart',
  components: {Myfooter},
  data(){
    return{
      activeName:'1',
      aa:1,
      bb:1,
      cc:1,
      myd:0,
      shareholders:{},
      selectShareholder:'',
      newShareholder:{
        name:'',
        value:0
      }
    }
  },
  watch:{
    aa:{
      handler(oldValue,newValue){
        if(newValue===''){
          this.aa=1
        }
        this.thirdEchart();
      },
    },
    bb:{
      handler(oldValue,newValue){
        if(newValue===''){
          this.bb=1
        }
        this.thirdEchart();
      },
    },
    cc:{
      handler(oldValue,newValue){
        if(newValue===''){
          this.cc=1
        }
        this.thirdEchart();
      },
    },
    myd:{
      handler(oldValue,newValue){
        if(newValue===''){
        }
        this.thirdEchart();
      },
    }
  },
  methods:{
    handleAddShareholder(){
    //  检查数据合理性
      if(this.newShareholder.name===""){this.$alert("股东名不能为空白");return;}
      if(this.newShareholder.value<=0){this.$alert("股份额应大于0");return;}
      var axios = this.$axios;
      var data = JSON.stringify(this.newShareholder);
      let that = this;
      var config = {
        method: 'post',
        url: this.$server + '/addShareholder',
        headers: {
          'User-Agent': 'Apifox/1.0.0 (https://www.apifox.cn)',
          'Content-Type': 'application/json',
          'Accept': '*/*',
          'Host': 'localhost:8080',
          'Connection': 'keep-alive'
        },
        data : data
      };
      axios(config)
        .then(function (response) {
          if (response.data.msg=='添加成功'){
            that.$message({
              type: 'success',
              message:'增加成功'
            });
          }else{
            that.$message({
              type: 'error',
              message:'增加失败'
            });
          }
          that.forthEchart();
        })
        .catch(function (error) {
          console.log(error);
          that.$message({
            type: 'error',
            message:'增加失败'
          });
          that.forthEchart();
        });


    },
    handleDelShareholder(){
      if(this.selectShareholder.name==""||this.selectShareholder.name==undefined){this.$alert("请选择一个股东");return;}
      let that=this;
      this.$confirm("是否确定要移除股东"+ this.selectShareholder.name + "?","提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning"
      }).then(()=>{
        var axios = this.$axios;
        var config = {
          method: 'post',
          url: this.$server + '/delShareholderByName?name=' + this.selectShareholder.name,
          headers: {
            'User-Agent': 'Apifox/1.0.0 (https://www.apifox.cn)',
            'Accept': '*/*',
            'Host': 'localhost:8080',
            'Connection': 'keep-alive'
          }
        };
        axios(config)
          .then(function (response) {
            if (response.data.code==1){
              that.$message({
                type: 'success',
                message:'删除成功'
              });
              that.selectShareholder.name='';
            }else{
              that.$message({
                type: 'error',
                message:'删除失败'
              });
            }
            that.forthEchart();
          })
          .catch(function (error) {
            console.log(error);
            that.$message({
              type: 'error',
              message:'删除失败'
            });
            that.forthEchart();
          });

      }).catch(()=>{
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    handleModifyShareholder(){
      if(this.selectShareholder.name==""||this.selectShareholder.name==undefined){this.$alert("请选择一个股东");return;}
      var axios = this.$axios;
      let that = this;
      var config = {
        method: 'post',
        url: this.$server + '/modifyShare?name=' + this.selectShareholder.name + '&newValue=' + this.selectShareholder.value,
        headers: {
          'User-Agent': 'Apifox/1.0.0 (https://www.apifox.cn)',
          'Accept': '*/*',
          'Host': 'localhost:8080',
          'Connection': 'keep-alive'
        }
      };

      axios(config)
        .then(function (response) {
          if (response.data.msg=='修改成功'){
            that.$message({
              type: 'success',
              message:'修改成功'
            });
          }else{
            that.$message({
              type: 'error',
              message:'修改失败'
            });
          }
          that.forthEchart();
        })
        .catch(function (error) {
          console.log(error);
          that.$message({
            type: 'error',
            message:'修改失败'
          });
          that.forthEchart();
        });

    },
    myEcharts(){
      // 基于准备好的dom，初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById('main'));
      // 指定图表的配置项和数据
      var option = {
        title: {
          text: 'My "Hello,world" ECharts',
        },
        tooltip: {},
        legend: {
          top:'10%',
          data:['销量']
        },
        xAxis: {
          data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
          name: '销量',
          type: 'bar',
          data: [5, 20, 36, 10, 10, 20]
        }]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    },
    forthEchart(){
      var forthChart = this.$echarts.init(document.getElementById('forthChart'),null,{height:800,width:1400});

      var option = {
        title: {
          text: '公司占股比例图(万元)',
          subtext: 'Fake Data',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: '股东',
            type: 'pie',
            radius: '50%',
            data: [
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      var axios = this.$axios;
      var config = {
        method: 'get',
        url: this.$server+'/queryAllShareholders',
        headers: {
          'User-Agent': 'Apifox/1.0.0 (https://www.apifox.cn)'
        }
      };
      let that=this;
      axios(config)
        .then(function (response) {
          option.series[0].data=(response.data.result);
          that.shareholders = response.data.result;
          forthChart.setOption(option);
        })
        .catch(function (error) {
          console.log(error);
        });

    },
    thirdEchart(){
      var that=this;
      var option;
      var thirdChart = this.$echarts.init(document.getElementById('thirdChart'),null,{height:800,width:1400});
      function func(x) {
        x /= 10;
        var a = that.aa;
        var b = that.bb;
        var c = that.cc;
        var d = that.myd;
        return (a * x ** 3 + b * x ** 2 + c * x + d/10*10);
      }
      function generateData() {
        let data = [];
        for (let i = -200; i <= 200; i += 0.1) {
          data.push([i, func(i)]);
        }
        return data;
      }
      option = {
        animation: false,
        grid: {
          top: 40,
          left: 50,
          right: 40,
          bottom: 50
        },
        xAxis: {
          name: 'x',
          minorTick: {
            show: true
          },
          minorSplitLine: {
            show: true
          }
        },
        yAxis: {
          name: 'y',
          min: -100,
          max: 100,
          minorTick: {
            show: true
          },
          minorSplitLine: {
            show: true
          }
        },
        dataZoom: [
          {
            show: true,
            type: 'inside',
            filterMode: 'none',
            xAxisIndex: [0],
            startValue: -20,
            endValue: 20
          },
          {
            show: true,
            type: 'inside',
            filterMode: 'none',
            yAxisIndex: [0],
            startValue: -20,
            endValue: 20
          }
        ],
        series: [
          {
            type: 'line',
            showSymbol: false,
            clip: true,
            data: generateData()
          }
        ]
      };

      thirdChart.setOption(option);
    },
    secondEcharts(){
      var secondChart = this.$echarts.init(document.getElementById('secondEchart'),null,{height:600,width:800});
      var option = {
        title: {
          text: '广西大学高考各专业录取分（广西地区）'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['计算机类', '机械类', '电子信息类', '电气类', '经济学类','轻工类','材料类','土木工程'],
          top:'10%',
          left:'10%'
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['2017', '2018', '2019', '2020', '2021', '2022']
        },
        yAxis: {
          type: 'value',
          min:500,
          max:600
        },
        series: [
          {
            name: '计算机类',
            type: 'line',
            data: [533,580,581,579,573,575]
          },
          {
            name: '机械类',
            type: 'line',
            data: [516,562,566,562,554,553]
          },
          {
            name: '电子信息类',
            type: 'line',
            data: [527,568,578,575,564,568]
          },
          {
            name: '电气类',
            type: 'line',
            data: [529,571,572,569,561,565]
          },
          {
            name: '经济学类',
            type: 'line',
            data: [551,584,579,571,560,555]
          },
          {
            name: '轻工类',
            type: 'line',
            data: [503,557,553,549,539,531]
          },
          {
            name: '土木工程',
            type: 'line',
            data: [537,586,587,575,561,550]
          },
          {
            name: '材料类',
            type: 'line',
            data: [504,554,556,551,544,531]
          }
        ]
      };
      secondChart.setOption(option);
    },
    getShareData(){


    }
  },
  mounted() {
    this.myEcharts();
    this.secondEcharts();
    this.thirdEchart();
    this.forthEchart();
  },

}
</script>

<style>
.mainland{
  margin: 10px 200px 10px 200px;
  margin-top: -30px;
}
.el-main{
  min-height: 750px;
}
.mains{
  width: 600px;height:800px;margin: 0px auto
}
.second{
  height: 850px;
  width: 1100px;
  margin: auto;
}
.intro{
  text-align: left;
  font-family: 等线;
}

.el-collapse-item{
  margin-bottom: 30px;
  font-size: 26px;
  font-weight: bold;
}

.el-collapse-item__header{
  font-size: 24px;
  font-weight: bold;
}
.para{
  font-size: 22px;
}
.myhead{
  font-size: 40px;
}
.mylink{
  background: #0066b1;
  color:#ffffff;
  overflow: hidden;
  z-index: 9999;
  position: fixed;
  padding:5px;
  text-align:center;
  width: 135px;
  height: 32px;
  font-size: 20px;
  font-weight: lighter;
  border-radius: 5px;
  cursor: pointer;
}
.position1{
  left:30px;
  top: 60px;
}
.position2{
  left: 30px;
  top: 120px;
}
</style>
