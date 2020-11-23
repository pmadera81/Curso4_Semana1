package com.pmadera.mascotas.resApi.adapter;

public final class ConstantesRestApi {

    public static final String ROOT_URL="https://graph.instagram.com/";
    public static final String ACCESS_TOKEN="IGQVJVaUw3bkpBelJvZAlFqam1PaW5hWUR6YUExTEZA4UXlhQy1yV1lvYnItVTZAhZAG42ODBFSzlFMGhoTXl1MkRVa2V1ZAnB1M2FzUC11ci0wVGloWVBaT1BVcDh6eEVkOF8zb0k1T2lieUJqUzNmdlhmZAgZDZD";
    public static final String KEY_ACCESS_TOKEN="&access_token=";
    public static final String KEY_GET_MEDIA_USER="me/media?fields=id,caption";

    public static final String URL_GET_MEDIA_USER=ROOT_URL + KEY_GET_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String KEY_ACCESS_FOTO="?fields=id,media_url";

    public static final String URL_CONTENIDO_FOTO = "https://graph.instagram.com/{id}?fields=id,media_url&access_token=IGQVJVaUw3bkpBelJvZAlFqam1PaW5hWUR6YUExTEZA4UXlhQy1yV1lvYnItVTZAhZAG42ODBFSzlFMGhoTXl1MkRVa2V1ZAnB1M2FzUC11ci0wVGloWVBaT1BVcDh6eEVkOF8zb0k1T2lieUJqUzNmdlhmZAgZDZD";

   }
