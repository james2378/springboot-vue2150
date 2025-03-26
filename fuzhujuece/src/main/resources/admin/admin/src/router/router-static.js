import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import shouzhi from '@/views/modules/shouzhi/list'
    import xiaoshou from '@/views/modules/xiaoshou/list'
    import xinzi from '@/views/modules/xinzi/list'
    import yuangong from '@/views/modules/yuangong/list'
    import dictionaryBumen from '@/views/modules/dictionaryBumen/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShouzhi from '@/views/modules/dictionaryShouzhi/list'
    import dictionaryShouzhiErji from '@/views/modules/dictionaryShouzhiErji/list'
        import dictionaryShouzhiErjiAddOrUpdate from '@/views/modules/dictionaryShouzhiErji/add-or-update'//二级
    import dictionaryXiaoshou from '@/views/modules/dictionaryXiaoshou/list'
    import dictionaryZhiwei from '@/views/modules/dictionaryZhiwei/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBumen',
        name: '部门',
        component: dictionaryBumen
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShouzhi',
        name: '收支类型',
        component: dictionaryShouzhi
    }
    ,{
        path: '/dictionaryShouzhiErji',
        name: '二级类型',
        component: dictionaryShouzhiErji
    }
    ,{
        path: '/dictionaryShouzhiErjiAddOrUpdate',
        name: '二级类型的新增修改页面',
        component: dictionaryShouzhiErjiAddOrUpdate
    }
    ,{
        path: '/dictionaryXiaoshou',
        name: '销售类型',
        component: dictionaryXiaoshou
    }
    ,{
        path: '/dictionaryZhiwei',
        name: '职位',
        component: dictionaryZhiwei
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/shouzhi',
        name: '收支',
        component: shouzhi
      }
    ,{
        path: '/xiaoshou',
        name: '销售订单',
        component: xiaoshou
      }
    ,{
        path: '/xinzi',
        name: '薪资',
        component: xinzi
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
