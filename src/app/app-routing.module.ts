import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { AppComponent } from './app.component';


const routes: Routes = [
  {
    path: "",
    redirectTo: "/home",
    pathMatch: 'full'
  }
  ,
  {path:'login',
loadChildren:()=>import('./login/login.module').then(m => m.LoginModule)
},
{path:'home',
loadChildren:()=>import('./home/home.module').then(m => m.HomeModule)
},
{path:'menu',
loadChildren:()=>import('./menu/menu.module').then(m => m.MenuModule)
},
{path:'cart',
loadChildren:()=>import('./cart/cart.module').then(m => m.CartModule)
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules }),],
  exports: [RouterModule]
})
export class AppRoutingModule { }
