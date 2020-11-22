using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Hosting;

namespace Api
{
    public class Program
    {
        public static void Main(string[] args)
        {
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    webBuilder.UseStartup<Startup>();
                });
    }
}


// RXVC4acV18hXYLlO
//mongodb+srv://api:<password>@cluster0.ghcbp.mongodb.net/<dbname>?retryWrites=true&w=majority

//mongodb+srv://api:RXVC4acV18hXYLlO@cluster0.ghcbp.mongodb.net/<dbname>?retryWrites=true&w=majority