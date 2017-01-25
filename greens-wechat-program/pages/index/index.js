//index.js
//获取应用实例
var app = getApp()
Page({
    data: {
        categoryIconActive: "beef",
        categories: [
            {image: "/images/beef.png", name: "牛肉", id: "beef"},
            {image: "/images/fish.png", name: "鱼", id: "fish"},
            {image: "/images/vegetables.png", name: "蔬菜", id: "vegetables"},
            {image: "/images/南瓜.png", name: "南瓜", id: "nangua"},
            {image: "/images/肉排.png", name: "肉排", id: "roupai"},
            {image: "/images/菜花.png", name: "菜花", id: "huacai"},
            {image: "/images/蟹.png", name: "蟹", id: "xie"},
            {image: "/images/辣椒.png", name: "辣椒", id: "lajiao"},

            {image: "/images/菜花.png", name: "菜花", id: "huacai1"},
            {image: "/images/蟹.png", name: "蟹", id: "xie1"},
            {image: "/images/辣椒.png", name: "辣椒", id: "lajiao1"},

            {image: "/images/菜花.png", name: "菜花", id: "huacai2"},
            {image: "/images/蟹.png", name: "蟹", id: "xie2"},
            {image: "/images/辣椒.png", name: "辣椒", id: "lajiao2"}

        ],
        commodities: [{
            salePrice: "32.99",
            id: 1,
            description: "套餐内含：新奥尔良风味鸡翅2块*5",
            name: "A新奥尔良十翅天团",
            image: "/images/goods/4-94-81df0da688c7c308c5a3b1d8a480cjpeg.jpeg"
        }, {
            salePrice: "32.99",
            id: 1,
            description: "套餐内含：北美特色枫香烤翅2块*2；香酥鸡米花*1；芝士黄金鸡球3只",
            name: "A超值小吃拼盘",
            image: "/images/goods/4-b7-4580a3b166dc9799af4314d1566a9jpeg.jpeg"
        }, {
            salePrice: "32.99",
            id: 1,
            description: "细腻软滑的红豆沙与绵密的慕斯在粉色蛋糕上相遇，宛如甜蜜回忆在唇齿间悄然绽放，让你感受香甜而不腻的口感，一",
            name: "就粉你浪漫慕斯蛋糕",
            image: "/images/goods/5-22-80b608d9ba0afb7592fb4d2dda13cjpeg.jpeg"
        }, {
            salePrice: "32.99",
            id: 1,
            description: "上层：意式班洽达培根搭配腊肉肠，如盛放的花朵；下层：北欧风情火腿、大虾、猪肉粒等丰富海陆馅料。饼边卷入浓",
            name: "双层饕餮芝士卷边比萨[纯珍][12寸]",
            image: "/images/goods/d-f4-06a959825fd0ef30eb36be655fa43jpeg.jpeg"
        }, {
            salePrice: "32.99",
            id: 1,
            description: "新年乐饕饕小吃拼盘：北美特色枫香烤翅(2块)*2; 傲椒红火翅(2块)*1; 烧烤BBQ鸡翅(2块); 骨肉相连(2串)*1; ",
            name: "新年乐饕饕小吃拼盘",
            image: "/images/goods/e-68-b6bb05e3cd06c473d72571d1c9eddjpeg.jpeg"
        }, {
            salePrice: "32.99",
            id: 1,
            description: "选用源自锡盟草原的羔羊肉，经孜然风味腌料腌渍后烤制，再撒上气味芳香浓烈的孜然粉，立即演绎出大草原般健康活",
            name: "A爆珠古早米浆饮",
            image: "/images/goods/4-b7-4580a3b166dc9799af4314d1566a9jpeg.jpeg"
        }, {
            salePrice: "32.99",
            id: 1,
            "name": "A傲椒红火翅(2块)",
            "image": "/images/goods/d-f4-06a959825fd0ef30eb36be655fa43jpeg.jpeg"
        }, {
            salePrice: "32.99",
            id: 1,
            description: "醇香浓郁的奶茶，搭配爆感十足的黑糯米爆爆珠，口中感受非同寻常的Q弹滋味，带来新鲜的味觉体验！(260ml)",
            name: "A热情羊溢烤串(2串)",
            image: "/images/goods/4-94-81df0da688c7c308c5a3b1d8a480cjpeg.jpeg"
        }, {
            salePrice: "32.99",
            id: 1,
            "name": "A爆爆珠奶茶",
            "image": "/images/goods/5-22-80b608d9ba0afb7592fb4d2dda13cjpeg.jpeg"
        }]
    },
    // 首页分享
    onShareAppMessage: function () {
        return {
            title: '自定义分享标题',
            desc: '自定义分享描述',
            path: '/page/index'
        }
    },
    // 类目 ICON 点击事件
    onChangeCategory: function (e) {
        this.setData({
            categoryIconActive: e.currentTarget.dataset.rowId
        });

        return;
    },
    onLoad: function () {

    }
})
