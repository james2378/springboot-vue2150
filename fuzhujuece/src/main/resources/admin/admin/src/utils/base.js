const base = {
    get() {
        return {
            url : "http://localhost:8080/fuzhujuece/",
            name: "fuzhujuece",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/fuzhujuece/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "商业辅助决策系统"
        } 
    }
}
export default base
