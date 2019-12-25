# Read Local JSON File

**Let's Start**

Buatlah folder asset di dalam folder src/main/... seperti gambar dibawah ini 

<img src="https://github.com/udindn/image/blob/master/json.PNG" width="400" height="190">

**Import GSON Library**

Tambahkan GSON Library kedalam file build.gradle

```
implementation 'com.google.code.gson:gson:2.8.5'
```

**Pemanggilan File**

```
var json: String? = null
        try {
            val inputStream = this.assets.open(filmData)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, StandardCharsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
```

**Parsing GSON**

```
val jsonString = getAssetsJSON()
        if (jsonString != null) {
            try {
                val response = JSONObject(jsonString)
                val json = response.getJSONArray("data").getJSONObject(0).getJSONArray("items")
                listItems.addAll(
                    Gson().fromJson(
                        json.toString(),
                        object : TypeToken<ArrayList<Hero>>() {}.type
                    )
                )
                adapter.heroes = listItems
                adapter.notifyDataSetChanged()
            } catch (ex: JSONException) {
                ex.printStackTrace()
            }
        }
```
