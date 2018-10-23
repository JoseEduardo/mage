using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public static class PlayerStats
{
    public static string sessionId;
    public static string gameId;
    public static string basePath = "http://127.0.0.1:9000/";
   	public static bool needSelectPlayer = false;
   	public static bool needAskPlayer = false;

   	public static string message  = "";
   	public static string rightBtn = "";
   	public static string leftBtn  = "";
}