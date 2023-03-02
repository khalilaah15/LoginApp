package com.example.ukl

object ProductData {
    private val data = arrayOf(
        arrayOf(
            "EXO - Pharynx",
            "Rp. 800.000,00",
            "https://m.media-amazon.com/images/I/51Y--WvsBDL.jpg"
        ),
        arrayOf(
            "BTS - Army Bomb",
            "Rp. 1.788.000,00",
            "https://i.pinimg.com/originals/3b/4d/2f/3b4d2f1b49ab08d9c179fc5b15b20f2b.jpg"
        ),
        arrayOf(
            "NCT - Meumwonbong",
            "Rp. 895.000,00",
            "https://i.pinimg.com/originals/aa/48/4c/aa484ca4a1d92c9c628f1f29d73db21f.jpg"
        ),
        arrayOf(
            "BLACKPINK - Byongbong",
            "Rp. 1.222.000,00",
            "https://i.pinimg.com/originals/d0/94/fb/d094fb8c13ef222748663436d21e36fb.jpg"
        ),
        arrayOf(
            "TREASURE - Teulight",
            "Rp. 1.119.000,00",
            "https://d2j6dbq0eux0bg.cloudfront.net/images/42115876/2596066268.jpg"
        ),
        arrayOf(
            "ENHYPEN - Enlight",
            "Rp. 1.044.000,00",
            "https://kpopmerchandiseguide.com/image/enhypen-official-light-stick.jpg"
        ),
        arrayOf(
            "TXT - Moabong",
            "Rp. 970.000,00",
            "https://i.pinimg.com/originals/90/be/32/90be323180ab81455ea4a600c3833228.png"
        ),
        arrayOf(
            "SEVENTEEN - CARATbong",
            "Rp. 1.225.500,00",
            "https://i.pinimg.com/originals/26/f5/42/26f5421e3f4d2f67a7624d5947f2ffb6.jpg"
        ),
        arrayOf(
            "aespa - Seubong/SBONG",
            "Rp. 1.065.000,00",
            "https://cf.shopee.co.id/file/c4506f04182f9c0ae245cf40985b7617"
        ),
        arrayOf(
            "iKON - KONBAT",
            "Rp. 988.000,00,",
            "https://cf.shopee.co.id/file/0c7e60bacffc3e175fb5eabeed5db7d8"
        )
    )
    val listProduct: ArrayList<Product>
        get() {
            val list = arrayListOf<Product>()
            for (aData in data) {
                val product = Product()
                product.name = aData[0]
                product.harga = aData[1]
                product.photo = aData[2]

                list.add(product)
            }
            return list
        }
}