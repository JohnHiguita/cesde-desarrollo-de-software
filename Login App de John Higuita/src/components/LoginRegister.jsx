import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import { Mail, Lock, User, Eye, EyeOff } from "lucide-react";

// Nuevo look: paleta verde/teal con acentos ámbar y tipografías distintas
// + Persistencia en localStorage para email/contraseña/usuario
export default function LoginRegister() {
  const [isLogin, setIsLogin] = useState(true);
  const [showPassword, setShowPassword] = useState(false);
  const [savedMsg, setSavedMsg] = useState("");
  const [form, setForm] = useState({ username: "", email: "", password: "" });

  // Cargar valores guardados al montar
  useEffect(() => {
    try {
      const savedEmail = localStorage.getItem("auth_email") || "";
      const savedPassword = localStorage.getItem("auth_password") || "";
      const savedUsername = localStorage.getItem("auth_username") || "";
      setForm({ username: savedUsername, email: savedEmail, password: savedPassword });
    } catch (_) {
      // localStorage no disponible (modo privado, etc.)
    }
  }, []);

  const toggleMode = () => setIsLogin(!isLogin);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((f) => ({ ...f, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    try {
      localStorage.setItem("auth_email", form.email);
      localStorage.setItem("auth_password", form.password);
      if (!isLogin) localStorage.setItem("auth_username", form.username);
      setSavedMsg("Datos guardados localmente ✓");
      setTimeout(() => setSavedMsg(""), 2000);
    } catch (err) {
      setSavedMsg("No se pudo guardar (revisa permisos de almacenamiento)");
      setTimeout(() => setSavedMsg(""), 3000);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-teal-700 via-emerald-600 to-lime-500 p-4 selection:bg-amber-300/70 selection:text-emerald-950">
      <motion.div
        initial={{ opacity: 0, scale: 0.96, y: 24 }}
        animate={{ opacity: 1, scale: 1, y: 0 }}
        transition={{ duration: 0.45, ease: "easeOut" }}
        className="w-[380px] max-w-[92vw]"
      >
        <div className="bg-emerald-50/90 backdrop-blur-xl rounded-3xl shadow-2xl p-7 border border-emerald-900/10">
          <div className="text-center mb-6">
            <p className="text-xs tracking-widest uppercase text-emerald-800/70 font-medium">Bienvenido</p>
            <h2 className="mt-1 text-3xl font-serif font-semibold text-emerald-900 drop-shadow-[0_1px_0_rgba(255,255,255,0.6)]">
              {isLogin ? "Inicia sesión" : "Crea tu cuenta"}
            </h2>
          </div>

          <form className="space-y-4" onSubmit={handleSubmit}>
            {!isLogin && (
              <div className="relative">
                <User className="absolute left-3 top-1/2 -translate-y-1/2 h-5 w-5 text-emerald-700/70" />
                <input
                  name="username"
                  type="text"
                  value={form.username}
                  onChange={handleChange}
                  placeholder="Nombre de usuario"
                  className="w-full pl-10 pr-3 py-2.5 rounded-2xl bg-white/70 border border-emerald-900/10 placeholder:text-emerald-800/40 text-emerald-950 shadow-sm focus:outline-none focus:ring-4 focus:ring-emerald-400/40 focus:border-emerald-500 transition"
                />
              </div>
            )}

            <div className="relative">
              <Mail className="absolute left-3 top-1/2 -translate-y-1/2 h-5 w-5 text-emerald-700/70" />
              <input
                name="email"
                type="email"
                value={form.email}
                onChange={handleChange}
                placeholder="Correo electrónico"
                className="w-full pl-10 pr-3 py-2.5 rounded-2xl bg-white/70 border border-emerald-900/10 placeholder:text-emerald-800/40 text-emerald-950 shadow-sm focus:outline-none focus:ring-4 focus:ring-emerald-400/40 focus:border-emerald-500 transition"
              />
            </div>

            <div className="relative">
              <Lock className="absolute left-3 top-1/2 -translate-y-1/2 h-5 w-5 text-emerald-700/70" />
              <input
                name="password"
                type={showPassword ? "text" : "password"}
                value={form.password}
                onChange={handleChange}
                placeholder="Contraseña"
                className="w-full pl-10 pr-11 py-2.5 rounded-2xl bg-white/70 border border-emerald-900/10 placeholder:text-emerald-800/40 text-emerald-950 shadow-sm focus:outline-none focus:ring-4 focus:ring-emerald-400/40 focus:border-emerald-500 transition"
              />
              <button
                type="button"
                aria-label={showPassword ? "Ocultar contraseña" : "Mostrar contraseña"}
                className="absolute right-2 top-1/2 -translate-y-1/2 p-1 rounded-xl hover:bg-emerald-100 active:scale-95 transition"
                onClick={() => setShowPassword((s) => !s)}
              >
                {showPassword ? (
                  <EyeOff className="h-5 w-5 text-emerald-800/80" />
                ) : (
                  <Eye className="h-5 w-5 text-emerald-800/80" />
                )}
              </button>
            </div>

            <motion.button
              whileTap={{ scale: 0.98 }}
              type="submit"
              className="w-full bg-gradient-to-r from-emerald-600 via-teal-600 to-emerald-700 text-white py-2.5 rounded-2xl shadow-md hover:opacity-95 active:opacity-90 transition ring-1 ring-emerald-900/10"
            >
              {isLogin ? "Entrar" : "Registrarse"}
            </motion.button>
          </form>

          {savedMsg && (
            <motion.p
              initial={{ opacity: 0, y: 6 }}
              animate={{ opacity: 1, y: 0 }}
              className="mt-3 text-center text-sm font-medium text-emerald-900"
            >
              {savedMsg}
            </motion.p>
          )}

          <p className="text-sm text-center mt-6 text-emerald-900/80">
            {isLogin ? "¿No tienes cuenta?" : "¿Ya tienes una cuenta?"}{" "}
            <button
              className="text-amber-700 font-semibold hover:underline focus:underline focus:outline-none"
              onClick={toggleMode}
              type="button"
            >
              {isLogin ? "Regístrate" : "Inicia sesión"}
            </button>
          </p>

          <div className="mt-4 text-[11px] text-emerald-900/70 text-center leading-relaxed">
            
          </div>
        </div>
      </motion.div>
    </div>
  );
}
