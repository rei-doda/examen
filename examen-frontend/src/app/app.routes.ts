import { Routes } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'auth/login', pathMatch: 'full' },

  // AUTH
  {
    path: 'auth',
    children: [
      {
        path: 'login',
        loadComponent: () =>
          import('./auth/login/login.component').then(m => m.LoginComponent)
      },
      {
        path: 'register',
        loadComponent: () =>
          import('./auth/register/register.component').then(m => m.RegisterComponent)
      }
    ]
  },

  // EXAMINATION
  {
    path: 'examination',
    canActivate: [AuthGuard],
    loadComponent: () =>
      import('./shared/features/examination/examination-today/examination-today.component')
        .then(m => m.ExaminationTodayComponent)
  },

  // TODOS
  {
    path: 'todos',
    canActivate: [AuthGuard],
    loadComponent: () =>
      import('./shared/features/todos/todo-list/todo-list.component')
        .then(m => m.TodoListComponent)
  },

  // CATEGORIES
  {
    path: 'categories',
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        loadComponent: () =>
          import('./categories/category-list/category-list.component')
            .then(m => m.CategoryListComponent)
      },
      {
        path: 'create',
        loadComponent: () =>
          import('./categories/category-create/category-create.component')
            .then(m => m.CategoryCreateComponent)
      },
      {
        path: 'edit/:id',
        loadComponent: () =>
          import('./categories/category-edit/category-edit.component')
            .then(m => m.CategoryEditComponent)
      }
    ]
  },

  // PROFILE
  {
    path: 'profile',
    canActivate: [AuthGuard],
    loadComponent: () =>
      import('./shared/features/profile/profile-dashboard/profile-dashboard.component')
        .then(m => m.ProfileDashboardComponent)
  },

  // WILDCARD
  { path: '**', redirectTo: 'auth/login' }
]; // <-- 🔥 THIS WAS MISSING
